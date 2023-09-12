package desafioobjetos.desafio2;

public class TestaFuncionario {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario("Giovanni","Martins",980957143,"Dev",2543.23);
        Funcionario funcionario2 = new Funcionario("Eliza","Wori",47623784,"mark",4523.23);
        Gerente gerente1 = new Gerente("Genivan","Silva",989856473,"Gerente Regional SUL",19.999,1);
        Gerente gerente2 = new Gerente("Luiza","Cruz",974658989,"Gerente Regional NORDESTE",21.546,2);
        Vendedor vendedor1 = new Vendedor("Cleiton","Klax",637402984,"Vendedor Varejista",1.432,1);
        Vendedor vendedor2 = new Vendedor("Olivia","Pinser",523142814,"Vendedor Atacadista",2.000,2);



        funcionario1.visualizar();
        funcionario2.visualizar();
        gerente1.visualizar();
        gerente2.visualizar();
        vendedor1.visualizar();
        vendedor2.visualizar();
    }
}
