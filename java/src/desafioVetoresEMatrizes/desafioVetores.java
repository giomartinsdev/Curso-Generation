package desafioVetoresEMatrizes;

import java.util.Scanner;

public class desafioVetores{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int vetor[] = {3,2,5,4,6,9,7,10,8,1};
        //define a variavel achou como false
        boolean achou = false;

        System.out.println("Digite o numero que gostaria de pesquisar no vetor");
        int numUsu = scan.nextInt();

        //roda um laço pra checar o valor de cada indice e ver se acha se achar muda a variavel achou para true e printa
        for (int i = 0; i < 10; i++) {
            int numVetor = vetor[i] ;
            if (numVetor == numUsu){
                System.out.println("O número " + numUsu + " está localizado na posição: " + i );
                achou = true;
            }
        }
        // se a variavel achou continuar false quer dizer que nao teve valor no array correspondente entao printa o erro
        if (achou == false){
                System.out.println("O número " + numUsu + " não foi encontrado!");
        }
    }
}
