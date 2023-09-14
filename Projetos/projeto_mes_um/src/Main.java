import methods.AddClientOnDb;
import methods.User;
import org.json.simple.JSONObject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        User user = null;

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
                    // Assuming login logic here
                    // For now, let's set a default user for testing
                    user = new User("Elias", "Klein", 19, 200.22, "elias123");
                    loginMenu = false;
                    break;

                case (2):
                    System.out.println("Insert your first name: ");
                    scan.nextLine();
                    String name = scan.nextLine();

                    System.out.println("Insert your surname: ");
                    String surname = scan.nextLine();

                    System.out.println("Insert your age: ");
                    int age = scan.nextInt();

                    float balance = 0.00F;

                    System.out.println("Insert pass: ");
                    scan.nextLine();
                    String pass = scan.nextLine();

                    // Criando um novo objeto JSON para o novo cliente
                    JSONObject novoCliente = new JSONObject();

                    //criando o obj publicInfo
                    JSONObject publicInfo = new JSONObject();
                    //inserindo as variaveis na correspondencia obj do publicjson
                    publicInfo.put("name", name);
                    publicInfo.put("surname", surname);
                    publicInfo.put("age", age);

                    //crirando o obj privateInfo
                    JSONObject privateInfo = new JSONObject();
                    //inserindo as variaveis na correspondencia do obj privatejson
                    privateInfo.put("balance", balance);
                    privateInfo.put("pass", pass);

                    //inserindo as duas no OBJETO novo cliente
                    novoCliente.put("public_info", publicInfo);
                    novoCliente.put("private_info", privateInfo);

                    AddClientOnDb.adClient("projeto_mes_um/src/database/db.json", novoCliente);

                    user = new User(name, surname, age, balance, pass);

                    loginMenu = false;
                    break;

                default:
                    System.out.println("Numero Invalido");
                    break;
            }
        }

        //logged menu
        boolean optionsMenu = true;
        while (optionsMenu) {
            System.out.println("**************** Hello! "+ user.getName()+" ******************");
            System.out.print(" 1 - Show Balance\n 2 - Deposit\n 3 - Withdraw\n 4 - Transfer\n 5 - View data of your account\n 0 - Exit\n");
            System.out.println("************** Select an option ******************");
            int optionsMenuInput = scan.nextInt();

            //options
            switch (optionsMenuInput) {
                case 1:
                    //show acc balance
                    System.out.println("Hi! " + user.getName() + " Your balance is: "+ user.seeBalance()+"$");
                    break;
                case 2:
                    //make a deposit
                    System.out.println("Input an value to be added: ");
                    double balanceToPut = scan.nextDouble();
                    user.deposit(balanceToPut);
                    System.out.println("Your Balance has an update of " + balanceToPut +" the new balance is: "+ user.getBalance()+"$");
                    break;
                case 3:
                    //make a withdraw
                    System.out.println("Input an value to be removed: ");
                    double balanceToBeRemoved = scan.nextDouble();

                    //logic of withdraws where are higher than the balance
                    if (user.withdraw(balanceToBeRemoved) == 0.0){
                        System.out.println("The value of " + balanceToBeRemoved + " is higher than your balance ");
                    }else{
                        System.out.println("Your Balance has an update of " + balanceToBeRemoved +" the new balance is: "+ user.getBalance());
                    }
                    break;
                case 4:
                    //code.
                    break;
                case 5:
                    //printar infos
                    // Use o método toString() para imprimir os detalhes do usuário
                    System.out.println(user);
                    break;
                case 0:
                    System.out.println("Saindo da aplicação");
                    optionsMenu = false;
                    break;
                default:
                    System.out.println("Please, choose a valid option");
                    break;
            }
        }
    }
}