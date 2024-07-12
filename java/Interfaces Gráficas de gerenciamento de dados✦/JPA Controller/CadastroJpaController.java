package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaQuery;
import model.Cadastro;

public class CadastroJpaController implements Serializable {
     public CadastroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cadastro cadastro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cadastro);
        em.getTransaction().commit();
        em.close();
    }

    public void edit(Cadastro cadastro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(cadastro);
        em.getTransaction().commit();
        em.close();
    }

    public void remove(Cadastro cadastro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(cadastro));
        em.getTransaction().commit();
        em.close();
    }

    public Cadastro find(Object id) {
        EntityManager em = emf.createEntityManager();
        Cadastro cadastro = em.find(Cadastro.class, id);
        em.close();
        return cadastro;
    }

    public List<Cadastro> findAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cadastro.class));
        List<Cadastro> result = em.createQuery(cq).getResultList();
        em.close();
        return result;
    }

    public List<Cadastro> findRange(int[] range) {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cadastro.class));
        javax.persistence.Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        List<Cadastro> result = q.getResultList();
        em.close();
        return result;
    }

    public int count() {
        EntityManager em = emf.createEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<Cadastro> rt = cq.from(Cadastro.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = em.createQuery(cq);
        int count = ((Long) q.getSingleResult()).intValue();
        em.close();
        return count;
    }
}
