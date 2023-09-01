package desafioscondicionais;

import java.util.Scanner;

public class Desafio3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("digite o seu nome: \n");
        String name = reader.next();

        System.out.println("digite a sua idade  : \n");
        int age = reader.nextInt();

        System.out.println("é sua primeira doação?: \n");
        boolean isTheFirstDonate = reader.nextBoolean();


        if (age < 18 || age > 69){
            System.out.println( name + " não está apte para doar sangue!");
        } else if (age > 59 && age < 70) {
            if (isTheFirstDonate == true){
                System.out.println( name + " não está apte para doar sangue!");
            }else{
                System.out.println( name + " está apte para doar sangue!");
            }
        }else {
            System.out.println( name + " está apte para doar sangue!");
        }
    }
}
