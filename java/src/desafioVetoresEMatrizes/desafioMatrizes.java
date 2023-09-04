package desafioVetoresEMatrizes;

import java.util.Locale;
import java.util.Scanner;

public class desafioMatrizes {
    public static void main(String[] args) {
        // Defina o uso do ponto como separador decimal
        //sei que nao aprendemos isso ainda mas isso é só para alterar a entrada para aceitar notas com . e nao ,
        Locale.setDefault(Locale.US);

        Scanner scan = new Scanner(System.in);
        //defino a matriz com uma linha(0) e dez colunas(0-9) para guardar o resultado
        double medias[][] = new double[1][10];

        //para cada coluna da matriz (10) rode o codigo.
        for (int c = 0; c < 10; c++) {
            //nesse trecho eu insiro as notas nas variaveis notasN usando double para guardar . flutuante
            System.out.println("Insira as notas do aluno " + (c + 1) + " no ano ex(0.0 10.0 5.0 10.0) uma de cada vez");
            System.out.println("nota 1*: ");
            double nota1 = scan.nextDouble();
            System.out.println("nota 2*: ");
            double nota2 = scan.nextDouble();
            System.out.println("nota 3*: ");
            double nota3 = scan.nextDouble();
            System.out.println("nota 4*: ");
            double nota4 = scan.nextDouble();


            //aqui realizo verificacoes para ver se alguma nota saiu errada, sendo maior que dez e altero ela realizando
            //uma reatribuicao de valor na variavel maior que dez
            if (nota1 > 10){
                System.out.println("A nota precisa ser um valor menor que dez! corrija o numero: ");
                nota1 = scan.nextDouble();
            } else if (nota2 > 10) {
                System.out.println("A nota precisa ser um valor menor que dez! corrija o numero: ");
                nota2 = scan.nextDouble();
            } else if (nota3 > 10) {
                System.out.println("A nota precisa ser um valor menor que dez! corrija o numero: ");
                nota3 = scan.nextDouble();
            }
            else if (nota4 > 10) {
                System.out.println("A nota precisa ser um valor menor que dez! corrija o numero: ");
                nota4 = scan.nextDouble();
            }

            //aqui eu pego e calculo a media
            double media = (nota1 + nota2 + nota3 + nota4) / 4;
            //aqui eu empurro a media na linha um(0) e passo a coluna de iteração como valor variavel dependendo do loop
            //for que esteja rolando no momento
            medias[0][c] = media;

        }
        //utilizo de um for de iteração para printar todos os valores da matriz
        for (int i = 0; i < 10; i++) {
            System.out.printf("Média do aluno %d: %.1f%n", (i + 1), medias[0][i]);
        }
    }
}
