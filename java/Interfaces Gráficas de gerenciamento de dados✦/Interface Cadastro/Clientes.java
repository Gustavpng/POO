package clientes;

import java.util.ArrayList;
import java.util.List;

public class Clientes {
    
    static List<Cadastro>clientes = new ArrayList<Cadastro>();
    
    static void inserirCliente(String nome){
        Cadastro c = new Cadastro(nome);
        clientes.add(c);
    }

    public static void main(String[] args) {
          new Interface();
    }
}
