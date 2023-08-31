import java.util.Scanner;

public class TransferenciaDeSaldo {
    public static void main(String[] args) {
        // Criando um objeto Scanner para ler entrada do usuário
        Scanner leitor = new Scanner(System.in);

        // Inicializando saldos iniciais das contas
        double contaSaldoUm = 201.20; // Saldo da primeira conta
        double contaSaldoDois = 321.92; // Saldo da segunda conta

        // Exibindo opções de ação para o usuário
        System.out.println("Digite o numero da ação que deseja realizar \n");
        System.out.println("1 - Saque\n");
        System.out.println("2 - Deposito\n");
        System.out.println("3 - transferencia\n");

        // Lendo a escolha do usuário
        int menuInput = leitor.nextInt();

        // Iniciando a estrutura de decisão com base na escolha do usuário
        switch (menuInput) {
            case 1:
                // Realizando o saque
                System.out.println("Seu saldo é " + contaSaldoUm + " quanto deseja sacar?");
                float valorSaque = leitor.nextFloat();
                double resulSaque = (contaSaldoUm - valorSaque); // Calculando o novo saldo após o saque
                contaSaldoUm = resulSaque; // Atualizando o saldo da primeira conta
                System.out.printf("Valor retirado foi %.2f. O saldo atual é %.2f", valorSaque, contaSaldoUm);
                break;
            case 2:
                // Realizando o deposito
                System.out.println("Seu saldo é " + contaSaldoUm + " quanto deseja adicionar?");
                float valorAdicionado = leitor.nextFloat();
                double resulAdicionado = (contaSaldoUm + valorAdicionado); // Calculando o novo saldo após o depósito
                contaSaldoUm = resulAdicionado; // Atualizando o saldo da primeira conta
                System.out.printf("Valor adicionado foi %.2f. O saldo atual é %.2f", valorAdicionado, contaSaldoUm);
                break;
            case 3:
                // Realizando uma transferência entre as contas um e dois
                System.out.println("Seu saldo é " + contaSaldoUm + " quanto deseja transferir?");
                float valorTransferencia = leitor.nextFloat();
                double resulSubtracao = (contaSaldoUm - valorTransferencia); // Calculando o novo saldo após a transferência na primeira conta
                double resulAdicao = (contaSaldoDois + valorTransferencia); // Calculando o novo saldo após a transferência na segunda conta
                contaSaldoUm = resulSubtracao; // Atualizando o saldo da primeira conta
                contaSaldoDois = resulAdicao; // Atualizando o saldo da segunda conta
                System.out.printf("Valor transferido foi %.2f. O saldo atual é %.2f\n", valorTransferencia, contaSaldoUm);
                System.out.printf("Saldo da conta destinatária é %.2f.", contaSaldoDois);
                break;
            default:
                // Tratando opção inválida
                System.out.println("Opção inválida");
        }
    }
}
