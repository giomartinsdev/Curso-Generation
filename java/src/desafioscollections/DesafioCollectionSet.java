package desafioscollections;
import java.util.Scanner;
import java.util.*;

public class DesafioCollectionSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //seto uma lista de inteiros que ja recebe um hashset com valores
        Set<Integer> setNumeros = new HashSet<>((Arrays.asList(2, 5, 1, 3, 4, 9, 7, 8, 10, 6)));

        System.out.println("Insira o valor para buscar no array");
        Integer numUsu = scan.nextInt();

        //cria um iterator utilizando o array setNumeros
        Iterator<Integer> isetIterator = setNumeros.iterator();

        //enquanto o iterator tiver um proximo numero (como um for(int i = 0; i < isetIterator.length; i++) {})
        while (isetIterator.hasNext()) {
            //se o array tiver o numero do usu
            if(setNumeros.contains(numUsu)){
                //printa que ele foi encontrado
                System.out.println("O número " + numUsu + " foi encontrado!");
                break;
            }else{
                System.out.println("O número " + numUsu + " não foi encontrado!");
                break;
            }

        }
    }
}
