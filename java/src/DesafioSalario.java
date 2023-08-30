import java.util.Scanner;

public class DesafioSalario {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite seu salário: ");
        float salario = leitor.nextFloat();

        System.out.println("Digite o abono salarial: ");
        float abono = leitor.nextFloat();

        float novoSalario = salario + abono;

        System.out.println(novoSalario);
    }
}
