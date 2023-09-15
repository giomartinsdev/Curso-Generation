package desafioobjetos.desafio1;

import java.util.Scanner;

public class TestaCliente {

    public static void main(String[] args) {
        PessoaFisica cliente1 = new PessoaFisica(null,0,0,'a',0,"A");
        PessoaJuridica cliente2 = new PessoaJuridica(null,0,0,'a',0,"A");

        cliente1.inputCliente();
        cliente1.visualizar();
        System.out.printf("\nO imc do cliente é: %.2f",cliente1.imc());
        cliente1.modeloCPF();


        cliente2.inputCliente();
        cliente2.visualizar();
        System.out.printf("\nO imc do cliente é: %.2f",cliente2.imc());
    }

}
