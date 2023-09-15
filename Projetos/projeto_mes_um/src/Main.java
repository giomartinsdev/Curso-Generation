import methods.AddClientOnDb;
import methods.Client;
import methods.User;
import org.json.simple.JSONObject;

import java.util.*;

public class Main extends Client {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        User user = null; // Inicializa um objeto "User" que será usado para representar o usuário logado

        boolean loginMenu = true;
        while (loginMenu) {
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
                    System.out.println("Please insert you name: ");
                    scan.nextLine();
                    String nameForLogin = scan.nextLine();
                    System.out.println("Please insert you pass: ");
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
                    scan.nextLine();
                    String pass = scan.nextLine();

                    // Criando um novo objeto JSON para o novo cliente
                    JSONObject novoCliente = new JSONObject();

                    // Criando o obj publicInfo
                    JSONObject publicInfo = new JSONObject();
                    // Inserindo as variaveis na correspondencia obj do publicjson
                    publicInfo.put("name", name);
                    publicInfo.put("surname", surname);
                    publicInfo.put("age", age);

                    // Crirando o obj privateInfo
                    JSONObject privateInfo = new JSONObject();
                    // Inserindo as variaveis na correspondencia do obj privatejson
                    privateInfo.put("balance", balance);
                    privateInfo.put("pass", pass);

                    // Inserindo as duas no OBJETO novo cliente
                    novoCliente.put("public_info", publicInfo);
                    novoCliente.put("private_info", privateInfo);

                    AddClientOnDb.adClient("projeto_mes_um/src/database/db.json", novoCliente);

                    user = new User(name, surname, age, balance, pass);

                    loginMenu = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

        // Logged menu
        boolean optionsMenu = true;
        while (optionsMenu) {
            System.out.println("**************** Hello! "+ user.getName()+" ******************");
            System.out.print(" 1 - Show Balance\n 2 - Deposit\n 3 - Withdraw\n 4 - Transfer\n 5 - View data of your account\n 0 - Exit\n");
            System.out.println("************** Select an option ******************");
            int optionsMenuInput = scan.nextInt();

            // Options
            switch (optionsMenuInput) {
                case 1:
                    // Show acc balance
                    System.out.println("Hi! " + user.getName() + " Your balance is: "+ user.seeBalance()+"$");
                    break;
                case 2:
                    // Make a Deposit
                    System.out.println("Input an value to be added: ");
                    double balanceToPut = scan.nextDouble();
                    boolean depositSuccess = Deposit(user.getName(), balanceToPut);
                    if (depositSuccess) {
                        System.out.println("Your Balance has an update of " + balanceToPut +" the new balance is: "+ (user.getBalance() + balanceToPut)+"$");
                    } else {
                        System.out.println("Failed to update balance. User not found.");
                    }
                    break;
                case 3:
                    // Make a withdraw
                    System.out.println("Input an value to be removed: ");
                    double balanceToBeRemoved = scan.nextDouble();

                    // Logic of withdraws where are higher than the balance
                    if (user.withdraw(balanceToBeRemoved) == 0.0){
                        System.out.println("The value of " + balanceToBeRemoved + " is higher than your balance ");
                    }else{
                        System.out.println("Your Balance has an update of " + balanceToBeRemoved +" the new balance is: "+ user.getBalance());
                    }
                    break;
                case 4:
                    // Code.
                    break;
                case 5:
                    // Printar infos
                    System.out.println("Your data in our database is(name, surname, age, pass): ");

                    // Criar uma collection arraylist para poder mostrar os dados do usuario
                    ArrayList<String> infos = new ArrayList<>();
                    // Adiciona os dados na arralist utilizando os getters
                    infos.add(user.getName());
                    infos.add(user.getSurname());
                    infos.add(user.getAge());
                    infos.add(user.getPass());

                    // Utiliza um iterator pra percorrer a lista printando o dado
                    Iterator<String> isetIterator = infos.iterator();
                    while(isetIterator.hasNext()){
                        System.out.println(isetIterator.next());
                    }
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