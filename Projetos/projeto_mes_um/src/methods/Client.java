package methods;

public abstract class Client implements DefaultMethods {

    //atributs
    private String name;
    private String surname;
    private Integer age;
    private double balance;
    private String pass;


    //getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }


    //constructor
    public Client(String name, String surname, Integer age, double balance, String pass) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.balance = balance;
        this.pass = pass;
    }
    public  Client(){

    }



    //Balance Methods//
    public void deposit(Double amount){
        this.balance = this.balance + amount;
    }

    public double withdraw(Double amount){
        //logic of withdraws where are higher than the balance
        if (this.balance > amount){
            this.balance = this.balance - amount;
            return this.balance;
        }else {
            return 0.0;
        }
    }

    public void transfer(Integer accountTargetId, Double amount){}
    public double seeBalance(){
        return this.balance;
    }

    //Clients methods//
    @Override
    public String toString() {
        return """
        Usuario:

        First name: """ + this.getName() + """

        Surname: """ + this.getSurname() + """

        Age: """ + this.getAge() + """

        Pass: """ + this.getPass();





//                "User{" +
//                "firstName='" + this.getName() + '\'' +
//                ", lastName='" + this.getSurname() + '\'' +
//                ", age=" + this.getAge() +
//                ", balance=" + this.getBalance() +
//                ", pass='" + getPass() + '\'' +
//                '}';
    }


}
