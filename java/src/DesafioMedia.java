import java.util.Scanner;

public class DesafioMedia {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite suas notas, uma de cada vez: ");
        System.out.println("Nota 1:");
        float nota1 = leitor.nextFloat();

        System.out.println("Nota 2:");
        float nota2 = leitor.nextFloat();

        System.out.println("Nota 3:");
        float nota3 = leitor.nextFloat();

        System.out.println("Nota 4:");
        float nota4 = leitor.nextFloat();

        float media = (nota1 + nota2 + nota3 + nota4) / 4;

        //regra de negocio, a media para passar de ano é 6
        if (media >= 6.0){
            System.out.println("Parabéns, Sua media é: " + media + " e você passou de ano");
            System.out.println("suas notas foram respectivamente: " + nota1 + nota2 + nota3 + nota4);
        }else{
            System.out.println("Infelizmente, Sua media é: " + media + " você ficou de recuperação");
            System.out.println("suas notas foram respectivamente: " + nota1 + ", " + nota2+  ", " + nota3 + "e " + nota4);
        }
    }
}
