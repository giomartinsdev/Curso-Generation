package methods;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class Client implements DefaultMethods {

    //------------------------------------------------------------------------------------------------------------//
    //atributs
    private String name;
    private String surname;
    private String age;
    private double balance;
    private String pass;

    //------------------------------------------------------------------------------------------------------------//
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
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
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
    public Client(String name, String surname, String age, double balance, String pass) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.balance = balance;
        this.pass = pass;
    }
    public  Client(){

    }


    //------------------------------------------------------------------------------------------------------------//
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

    //------------------------------------------------------------------------------------------------------------//
    //Clients methods//
    @Override
    public String toString() {
        return """
        Usuario:

        First name: """ + this.getName() + """

        Surname: """ + this.getSurname() + """

        Age: """ + this.getAge() + """

        Pass: """ + this.getPass();
    }

    public static JSONObject FindClient(String caminhoArquivo, String nome) {
        JSONParser parser = new JSONParser();

        try {
            // Obter o caminho atual do diretório
            String diretorioAtual = new File(".").getCanonicalPath();
            // Combinar o caminho do arquivo com o caminho atual
            String caminhoCompleto = diretorioAtual + "/" + caminhoArquivo;

            // Tentar ler o arquivo JSON
            try (FileReader reader = new FileReader(caminhoCompleto)) {
                // Parse do JSON
                Object obj = parser.parse(reader);
                JSONArray clientes = (JSONArray) obj;

                // Percorre a lista de clientes
                for (Object clienteObj : clientes) {
                    JSONObject cliente = (JSONObject) clienteObj;
                    JSONObject publicInfo = (JSONObject) cliente.get("public_info");
                    String nomeCliente = (String) publicInfo.get("name");

                    // Verifica se o nome do cliente corresponde ao nome fornecido
                    if (nomeCliente.equalsIgnoreCase(nome)) {
                        return cliente; // Encontrou o cliente com o nome desejado
                    }
                }
            } catch (IOException | org.json.simple.parser.ParseException e) {
                e.printStackTrace(); // Trata exceções de leitura ou parsing
            }
        } catch (IOException e) {
            e.printStackTrace(); // Trata exceções de caminho de arquivo inválido
        }

        return null; // Retorna null se o cliente não for encontrado
    }

    public static JSONObject LoginMethod(String name, String pass){
        return FindClient("projeto_mes_um/src/database/db.json", name);
    }

}
