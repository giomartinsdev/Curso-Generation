package desafioobjetos.desafio2;

public class TestaFuncionario {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario("Giovanni","Martins",980957143,"Dev",2543.23);
        Funcionario funcionario2 = new Funcionario("Eliza","Wori",47623784,"mark",4523.23);
        funcionario1.visualizar();
        funcionario2.visualizar();
    }
}
