package desafiosestuturadedados;

import java.util.Scanner;
import java.util.Stack;

public class DesafioEstruturaDeDadosPilha {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        boolean menuOn = true;

        while (menuOn) {
            System.out.println("**************************************************");
            System.out.println("""
                    1 - Adicionar Livro na pilha
                    2 - Listar todos os livro
                    3 - Retirar livro da pilha
                    0 - Sair""");
            System.out.println("**************************************************");
            System.out.println("Entre com a opção desejada:");
            int menuInput = scan.nextInt();

            switch (menuInput) {
                case 1:
                    System.out.println("Entre com o nome do livro:");
                    String livro = scan.next();
                    stack.push(livro);
                    System.out.println("Livro Adicionado!");
                    break;
                case 2:
                    System.out.println("Aqui estão todos os Livros:");
                    if (stack.isEmpty()) {
                        System.out.println("A stack está vazia");
                    } else {
                        for (String s : stack) {
                            System.out.println(s);
                        }
                        menuOn = false;
                        break;
                    }
                    break;
                case 3:

                    if (stack.isEmpty()){
                        System.out.println("A stack está vazia!");
                        break;
                    }else {
                        stack.pop();
                        for (String s : stack) {
                            System.out.println(s);
                        }
                        System.out.println("O Livro foi removido!");
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
