package desafiosforwhiledowhile;

import java.util.Scanner;

public class DesafioWhile {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int novos = 0;
        int velhos = 0;
        boolean idadeNegativa = false;

        System.out.println("Digite uma idade: ");
        int idadePessoa = leitor.nextInt();

        if(idadePessoa < 0){
            System.out.println("");
        }else {
            while (!idadeNegativa) {
                if (idadePessoa < 21) {
                    novos++;
                } else if (idadePessoa > 50) {
                    velhos++;
                }

                System.out.println("Digite uma idade: ");
                idadePessoa = leitor.nextInt();

                if (idadePessoa < 0) {
                    idadeNegativa = true;
                }
            }
        }
        System.out.println("Total de pessoas menores de 21 anos: " + novos);
        System.out.println("Total de pessoas maiores de 50 anos: " + velhos);

        
    }
}
