package desafioscondicionais;

import java.util.Scanner;

public class Desafio1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Digite o primeiro numero da soma: \n");
        int num1 = reader.nextInt();
        System.out.println("Digite o segundo numero da soma: \n");
        int num2 = reader.nextInt();
        System.out.println("Digite o resultado da soma: \n");
        int num3 = reader.nextInt();
        var sumResult = num1 + num2;
        if(sumResult > num3){
            System.out.println(num2 + " + " + num1 + " = " + sumResult + " > " + 5 );
            System.out.println("Não a equação nao esta correta, o valor é maior que " + num3);
        }else if (sumResult < num3) {
            System.out.println(num2 + " + " + num1 + " = " + sumResult + " < " + 5 );
            System.out.println("Não a equação nao esta correta, o valor é menor que " + num3);
        }else{
            System.out.println(num2 + " + " + num1 + " = " + sumResult + " = " + sumResult );
            System.out.println("Sim a equação esta correta");
        }
    }
}
