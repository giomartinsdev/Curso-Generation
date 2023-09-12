package treinopoo;


public class Account {
    private Double balance;
    private String ownerName;
    private String email;
    private String pass;
    private String ssn;

    public Account(Double balance, String ownerName, String email, String pass, String ssn) {
        this.balance = balance;
        this.ownerName = ownerName;
        this.email = email;
        this.pass = pass;
        this.ssn = ssn;
    }
    public Account() {

    }


    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}
