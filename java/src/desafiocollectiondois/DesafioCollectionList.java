package desafiocollectiondois;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DesafioCollectionList {
    public static void main(String[] args) {
        ArrayList<String> cores = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println((i+1) + " - Coloque a cor que você deseja adicionar");
            String inputUsu = scan.nextLine();
            cores.add(inputUsu);
        }

        System.out.println("Listar todas as cores:\n");
        for (String c:cores){
            System.out.println(c);
        }

        System.out.println("\n----------------------------\n");

        System.out.println("Ordenar as cores:");
        Collections.sort(cores);
        for (String i:cores){
            System.out.println(i);
        }
    }
}
