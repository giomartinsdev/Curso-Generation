package methods;

import org.json.simple.JSONObject;

public class User extends Client {
    //constructor
    public User(String name, String surname, String age, double balance, String pass) {
        super(name, surname, age, balance, pass);
    }
    public User(JSONObject jsonObject) {

    }
}

