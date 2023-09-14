package methods;

public interface DefaultMethods {

    //Balance Methods//
    public void deposit(Double amount);
    public double withdraw(Double amount);
    public void transfer(Integer accountTargetId, Double amount);
    public double seeBalance();

    //Clients methods//

}
