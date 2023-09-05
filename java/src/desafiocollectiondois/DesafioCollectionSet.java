package desafiocollectiondois;

import java.util.*;

public class DesafioCollectionSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<Integer> setNumeros = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("Adicione o " + (i+1) + "* numero");
            setNumeros.add(scan.nextInt());
        }

        System.out.println("\n---------Listar dados do Set:---------\n");

        Iterator<Integer> isetIterator = setNumeros.iterator();
        while(isetIterator.hasNext()){
            System.out.println(isetIterator.next());
        }
    }
}
