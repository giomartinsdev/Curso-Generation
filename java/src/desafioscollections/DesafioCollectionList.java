package desafioscollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DesafioCollectionList {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(2, 5, 1, 3, 4, 9, 7, 8, 10, 6));
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o número que você deseja encontrar: ");

        Integer numeroUsu = scan.nextInt();
        Integer indexOfNumeroUsu = numeros.indexOf(numeroUsu);

        if (indexOfNumeroUsu == -1){
            System.out.println("O número " + numeroUsu + " não foi encontrado!");
        }else {
            System.out.println("O numero " + numeroUsu + " está localizado na posição: " + indexOfNumeroUsu);
        }
        for (int i = 0; i < 1 ; i++) {
            System.out.println("");
        }
    }
}
