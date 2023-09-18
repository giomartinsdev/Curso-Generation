import methods.User;
import org.json.simple.JSONObject;
import java.util.*;

import static methods.Client.LoginMethod;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        User user = null; // Inicializa um objeto "User" que será usado para representar o usuário logado

        boolean loginMenu = true;
        while (loginMenu) {
            // Menu de Login
            System.out.print(
                    """
                    **************************************************
                    1 - Login
                    2 - Register
                    **************************************************
                    Select an Input:
                    """);
            int loginMenuInput = scan.nextInt();
            switch (loginMenuInput) {
                case (1):
                    // Realiza o login
                    System.out.println("******************** LOGIN PLATFORM ********************");
                    System.out.println("Please insert your name: ");
                    scan.nextLine();
                    String nameForLogin = scan.nextLine();
                    System.out.println("Please insert your pass: ");
                    String passForLogin = scan.nextLine();
                    JSONObject clienteEncontrado = LoginMethod(nameForLogin, passForLogin);

                    if (clienteEncontrado != null) {
                        // Extraia as informações do cliente e crie um novo usuário
                        JSONObject publicInfo = (JSONObject) clienteEncontrado.get("public_info");
                        JSONObject privateInfo = (JSONObject) clienteEncontrado.get("private_info");

                        String name = (String) publicInfo.get("name");
                        String surname = (String) publicInfo.get("surname");
                        String age = publicInfo.get("age").toString();
                        double balance = (double) privateInfo.get("balance");
                        String pass = (String) privateInfo.get("pass");

                        if (passForLogin.equals(pass)){
                            user = new User(name, surname, age, balance, pass);
                            loginMenu = false;
                            break;
                        }
                        else{
                            System.out.println("A senha que você digitou está errada, faça login novamente.");
                            break;
                        }
                    }
                case (2):
                    // Registra um novo cliente
                    System.out.println("Insert your first name: ");
                    scan.nextLine();
                    String name = scan.nextLine();

                    System.out.println("Insert your surname: ");
                    String surname = scan.nextLine();

                    System.out.println("Insert your age: ");
                    String age = scan.nextLine();

                    float balance = 0.00F; // O saldo é inicializado com 0.00F

                    System.out.println("Insert pass: ");
                    String pass = scan.nextLine();

                    // Criando um novo objeto JSON para o novo cliente
                    JSONObject novoCliente = new JSONObject();

                    // Criando o obj publicInfo
                    JSONObject publicInfo = new JSONObject();
                    // Inserindo as variáveis no correspondente obj do publicJson
                    publicInfo.put("name", name);
                    publicInfo.put("surname", surname);
                    publicInfo.put("age", age);

                    // Criando o obj privateInfo
                    JSONObject privateInfo = new JSONObject();
                    // Inserindo as variáveis no correspondente obj privateJson
                    privateInfo.put("balance", balance);
                    privateInfo.put("pass", pass);

                    // Inserindo os dois no OBJETO novoCliente
                    novoCliente.put("public_info", publicInfo);
                    novoCliente.put("private_info", privateInfo);

                    user.addClient("projeto_mes_um/src/database/db.json", novoCliente);

                    user = new User(name, surname, age, balance, pass);

                    loginMenu = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

        // Menu logado
        boolean optionsMenu = true;
        while (optionsMenu) {
            System.out.println("**************** Hello! "+ user.getName()+" ******************");
            System.out.print(" 1 - Show Balance\n 2 - Deposit\n 3 - Withdraw\n 4 - Transfer\n 5 - View data of your account\n 0 - Exit\n");
            System.out.println("************** Select an option ******************");
            int optionsMenuInput = scan.nextInt();

            // Opções
            switch (optionsMenuInput) {
                case 1:
                    // Mostra o saldo da conta
                    System.out.println("Hi! " + user.getName() + " Your balance is: " + user.SeeBalance(user.getName()) +"$");
                    break;
                case 2:
                    // Realiza um depósito
                    System.out.println("Input a value to be added: ");
                    double balanceToPut = scan.nextDouble();
                    boolean depositSuccess = user.Deposit(user.getName(), balanceToPut);
                    if (depositSuccess) {
                        System.out.println("Your Balance has been updated by " + balanceToPut +" and the new balance is: "+ user.SeeBalance(user.getName()) +"$");
                    } else {
                        System.out.println("Failed to update balance. User not found.");
                    }
                    break;
                case 3:
                    // Realiza um saque
                    System.out.println("Input a value to be removed: ");
                    double balanceToBeRemoved = scan.nextDouble();

                    // Lógica para saques maiores do que o saldo
                    if (user.Withdraw(user.getName(), balanceToBeRemoved)){
                        System.out.println("Your Balance has been updated by " + balanceToBeRemoved +" and the new balance is: "+  user.SeeBalance(user.getName()) +"$");
                    }else{
                        System.out.println("The value of " + balanceToBeRemoved + " is higher than your balance ");
                    }
                    break;
                case 4:
                    // Realiza uma transferência
                    System.out.println("Input the name of the target account owner: ");
                    scan.nextLine();
                    String nameTarget = scan.nextLine();
                    System.out.println("Input the amount of the Transfer: ");
                    Double amount = scan.nextDouble();
                    if (user.Transfer(nameTarget, user.getName(),amount)){
                        System.out.println("Transfer done successfully!");
                    }else {
                        System.out.println("An error has occurred, please try the Transfer again.");
                    }
                    break;
                case 5:
                    // Exibe informações
                    System.out.println("Your data in our database are (name, surname, age, pass): ");
                    // Cria uma coleção ArrayList para exibir os dados do usuário
                    ArrayList<String> infos = new ArrayList<>();
                    infos.stream();
                    // Adiciona o usuario atual na arraylist
                    infos.add(user.getName());
                    infos.add(user.getSurname());
                    infos.add(user.getAge());
                    infos.add(user.getPass());

                    //printa todas as inforacoes do usuario
                    infos.forEach(x -> System.out.println(x));
                    break;
                case 0:
                    System.out.println("Exiting the application");
                    optionsMenu = false;
                    break;
                default:
                    System.out.println("Please, choose a valid option");
                    break;
            }
        }
    }
}