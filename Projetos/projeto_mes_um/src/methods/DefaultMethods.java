package methods;

public interface DefaultMethods {

    //Balance Methods//
    public static boolean Deposit(String nomeCliente, double amount){return false;};
    public double withdraw(Double amount);
    public void transfer(Integer accountTargetId, Double amount);
    public double seeBalance();

    //Clients methods//

}
