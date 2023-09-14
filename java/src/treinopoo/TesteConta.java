package treinopoo;
import java.util.Scanner;

public class TesteConta {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //conta padrao
        Account account = new Account();

        boolean loginMenu = true;
        while (loginMenu) {
            System.out.print
                    ("""
                    **************************************************
                    1 - Login
                    2 - Register
                    **************************************************
                    Selected Input:
                    """);
            int loginMenuInput = scan.nextInt();
            switch (loginMenuInput){
                case(1):
                    loginMenu = false;
                    account = new Account(123.53,"Giovanni", "Giovanni@martins.com", "1234", "7786897261" );
                    break;
                case(2):
                    System.out.println("Insert your name: ");
                    scan.nextLine();
                    String ownerName = scan.nextLine();
                    System.out.println("Insert your email: ");
                    String email = scan.nextLine();
                    System.out.println("Insert your pass: ");
                    String pass = scan.nextLine();
                    System.out.println("Insert your ssn: ");
                    String ssn = scan.nextLine();
                    account = new Account(0.0,ownerName,email,pass,ssn);
                    loginMenu = false;
                    break;
                default:
                    System.out.println("Numero Invalido");
                    break;

            }
        }



        boolean optionsMenu = true;
        while (optionsMenu) {
            System.out.println("**************** Hello! "+account.getOwnerName()+" ******************");
            System.out.print(" 1 - Show Balance\n 2 - Add a value\n 3 - Remove value\n 4 - View data of your account\n 0 - Exit\n");
            System.out.println("************** Select the option ******************");
            int optionsMenuInput = scan.nextInt();

            switch (optionsMenuInput) {
                case 1:
                    System.out.println("Hi! " + account.getOwnerName() + " Your balance is: "+account.getBalance()+"$");
                    break;
                case 2:
                    System.out.println("Input an value to be added: ");
                    double balanceToPut = scan.nextDouble();
                    account.setBalance(account.getBalance() + balanceToPut);
                    System.out.println("Your Balance has an update of " + balanceToPut +" the new balance is: "+account.getBalance());
                    break;
                case 3:
                    System.out.println("Input an value to be removed: ");
                    double balanceToBeRemoved = scan.nextDouble();
                    account.setBalance(account.getBalance() - balanceToBeRemoved);
                    System.out.println("Your Balance has an update of " + balanceToBeRemoved +" the new balance is: "+account.getBalance());
                    break;
                case 4:
                    System.out.println("Hi! " + account.getOwnerName() + " Your DATA with us is: "
                            + "\n Email: " + account.getEmail()
                            + "\n Name: " + account.getOwnerName()
                            + "\n Balance: " + account.getBalance()
                            + "\n Ssn: " + account.getSsn()
                            + "\n Pass: " + account.getPass()

                    );
                    break;
                case 0:
                    System.out.println("0");
                    optionsMenu = false;
                    break;
                default:
                    System.out.println("def");
                    optionsMenu = false;
                    break;
            }
        }
    }
}
