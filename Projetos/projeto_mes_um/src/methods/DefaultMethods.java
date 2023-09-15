package methods;

public interface DefaultMethods {

    // Balance Methods
    boolean deposit(String customerName, double amount);

    boolean withdraw(String customerName, double amount);

    boolean transfer(String targetName, String sourceName, Double amount);

    double getBalance(String customerName);

}
