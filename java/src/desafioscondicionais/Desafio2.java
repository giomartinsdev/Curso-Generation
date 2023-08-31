package desafioscondicionais;

import java.util.Scanner;

public class Desafio2 {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("digite o numero: \n");
        int num = reader.nextInt();
        
        if (num >= 0 && num % 2 == 0){
            System.out.println("O Número " + num + " é par e positivo!");
        } else if (num <= 0 && num % 2 == 0) {
            System.out.println("O Número " + num + " é par e negativo!");
        } else if (num <= 0 && num % 2 != 0) {
            System.out.println("O Número " + num + "é impar e negativo!");
        } else if (num >= 0 && num % 2 != 0) {
            System.out.println("O Número " + num + " é ímpar e positivo!");
        }
    }
}
