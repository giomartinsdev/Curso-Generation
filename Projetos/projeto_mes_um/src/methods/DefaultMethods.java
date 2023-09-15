package methods;

public interface DefaultMethods {

    // Balance Methods
    boolean Deposit(String customerName, double amount);

    boolean Withdraw(String customerName, double amount);

    boolean Transfer(String targetName, String sourceName, Double amount);

    double SeeBalance(String customerName);

}
