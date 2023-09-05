package desafiosestuturadedados;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DesafioEstruturaDeDadosFila {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue<String> fila = new LinkedList<>();
        boolean menuOn = true;

        while (menuOn) {
            System.out.println("**************************************************");
            System.out.println("""
                    1 - Adicionar cliente na fila
                    2 - Listar todos os clientes da fila
                    3 - Retirar clientes da fila
                    0 - Sair""");
            System.out.println("**************************************************");
            System.out.println("Entre com a opção desejada:");
            int menuInput = scan.nextInt();

            switch (menuInput) {
                case 1:
                    System.out.println("Entre com o nome da pessoa para entrar na fila:");
                    scan.nextLine();
                    String nome = scan.nextLine();
                    fila.add(nome);
                    System.out.println("Cliente Adicionado!");
                    break;
                case 2:
                    System.out.println("Aqui estão todos os integrantes da fila:");
                    if (fila.isEmpty()) {
                        System.out.println("A fila está vazia");
                    } else {
                        for (String s : fila) {
                            System.out.println(s);
                        }
                        menuOn = false;
                        break;
                    }
                    break;
                case 3:
                    if (fila.isEmpty()) {
                        System.out.println("A fila está vazia");
                        break;
                    }else {
                        fila.remove();
                        for (String s : fila) {
                            System.out.println(s);
                        }
                        System.out.println("O Cliente foi Chamado!");
                        menuOn = false;
                        break;
                    }
                case 0:
                    System.out.println("Saindo do programa.");
                    menuOn = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
