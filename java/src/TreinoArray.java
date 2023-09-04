import java.util.Scanner;

public class TreinoArray{
    public static void main(String[] args) {
//        int vetorDeInteiros[] = {1, 2, 3, 4, 5};
//        String[] vetorDeStrings = {"Giovanni", "Ricardo", "Tobias"};
//        int vetorInstanciado[] = new int[5];
//        String vetorInstanciadoDois[] = new String[3];
//        String vetorDeStrings[] = {"Giovanni", "Ricardo", "Tobias"};

        Scanner Leitor = new Scanner(System.in);


        //cria um vetor de 5 posicoes para armazenar os dados
        int vetorDeInteiros[] = new int [5];

        //faz um for de iteração para soltar no usuario uma mensagem de input por 5 vezes para colocar os dados no array
        for (int i = 0; i < 5; i++) {
            //usa i+1 para passar o indice
            System.out.println("digite o " + (i+ 1) + " Numero: ");

            //vetordeinteiros passando o indice atual = ao input do usuario portanto ele vai guardar um valor no indece
            vetorDeInteiros[i] = Leitor.nextInt();
        }
        System.out.println("Os numeros digitados foram");

        for (int i = 0; i < 5; i++) {
            //roda o array printando
            System.out.println((i + 1) + "* numero:" + vetorDeInteiros[i] );
        }

    }
}
