package desafiosforwhiledowhile;

import java.util.Scanner;

public class DoWhile {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean valorZero = false;
        int count = 0;
        do {
            System.out.println("Digite um numero: ");
            int numUsu = leitor.nextInt();
            if (numUsu == 0){
                System.out.println("Zero digitado, saindo da função");
                System.out.println("resultado é: " + count);
                valorZero = true;
            }else {
              count = (count + numUsu);
            }
        }while (!(valorZero));

    }
}

