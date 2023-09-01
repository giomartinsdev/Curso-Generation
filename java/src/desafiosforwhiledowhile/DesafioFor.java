package desafiosforwhiledowhile;

import java.util.Scanner;

public class DesafioFor {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o primeiro número do intervalo:");

        int num1 = leitor.nextInt();;
        System.out.println("Digite o segundo número do intervalo:");
        int num2 = leitor.nextInt();;

        if (num1 > num2){
            System.out.println ("Intervalo inválido!");
        }else {
            for (int i = num1; i <= num2; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println(i + " é multiplo de 3 e 5");
                }
            }
        }
    }
}
