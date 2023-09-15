package methods;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Client implements DefaultMethods {

    //------------------------------------------//atributs//-----------------------------------------------------//
    private String name;
    private String surname;
    private String age;
    private double balance;
    private String pass;

    //----------------------------------//getters and setters methods//-----------------------------------------//
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


    //------------------------------------------//Balance methods//-----------------------------------------------------//


    public static boolean Deposit(String nome, double amount) {
        JSONParser parser = new JSONParser();

        try {
            String caminhoCompleto = "projeto_mes_um/src/database/db.json";

            // Encontra o cliente pelo nome
            JSONObject cliente = FindClient(caminhoCompleto, nome);

            if (cliente != null) {
                // Atualiza o saldo
                JSONObject privateInfo = (JSONObject) cliente.get("private_info");
                Double balance = (Double) privateInfo.get("balance");
                double newBalance = balance + amount;
                privateInfo.put("balance", newBalance);

                // Lê o conteúdo atual do arquivo JSON
                Object obj = parser.parse(new FileReader(caminhoCompleto));
                JSONArray clientes = (JSONArray) obj;

                // Atualiza os dados do cliente em questão
                for (Object clienteObj : clientes) {
                    JSONObject clienteAtual = (JSONObject) clienteObj;
                    JSONObject publicInfo = (JSONObject) clienteAtual.get("public_info");
                    String nomeCliente = (String) publicInfo.get("name");

                    if (nomeCliente.equalsIgnoreCase(nome)) {
                        clienteAtual.put("private_info", privateInfo);
                        break;
                    }
                }

                // Salva o conteúdo atualizado de volta no arquivo JSON
                try (FileWriter file = new FileWriter(caminhoCompleto)) {
                    String formattedJson = formatJson(clientes.toString());
                    file.write(formattedJson);
                    file.flush();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        return false; // Retorna false se o cliente não for encontrado
    }
    public static boolean Withdraw(String nome, double amount) {
        JSONParser parser = new JSONParser();

        try {
            String caminhoCompleto = "projeto_mes_um/src/database/db.json";

            // Encontra o cliente pelo nome
            JSONObject cliente = FindClient(caminhoCompleto, nome);

            if (cliente != null) {
                // Atualiza o saldo
                JSONObject privateInfo = (JSONObject) cliente.get("private_info");
                Double balance = (Double) privateInfo.get("balance");
                double newBalance = balance - amount;
                if (amount > balance){
                    return false;
                }
                privateInfo.put("balance", newBalance);

                // Lê o conteúdo atual do arquivo JSON
                Object obj = parser.parse(new FileReader(caminhoCompleto));
                JSONArray clientes = (JSONArray) obj;

                // Atualiza os dados do cliente em questão
                for (Object clienteObj : clientes) {
                    JSONObject clienteAtual = (JSONObject) clienteObj;
                    JSONObject publicInfo = (JSONObject) clienteAtual.get("public_info");
                    String nomeCliente = (String) publicInfo.get("name");

                    if (nomeCliente.equalsIgnoreCase(nome)) {
                        clienteAtual.put("private_info", privateInfo);
                        break;
                    }
                }

                // Salva o conteúdo atualizado de volta no arquivo JSON
                try (FileWriter file = new FileWriter(caminhoCompleto)) {
                    String formattedJson = formatJson(clientes.toString());
                    file.write(formattedJson);
                    file.flush();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        return false; // Retorna false se o cliente não for encontrado
    }
    public static boolean Transfer(String nomeTarget, String nomeUsu, Double amount) {
        String caminhoCompleto = "projeto_mes_um/src/database/db.json";

        // Encontrar os dois clientes
        JSONObject cliente = FindClient(caminhoCompleto, nomeUsu );
        JSONObject clienteTarget = FindClient(caminhoCompleto, nomeTarget );

        if (cliente != null) {
            if (clienteTarget != null){
                // Atualiza o saldo
                JSONObject privateInfo = (JSONObject) cliente.get("private_info");
//                JSONObject privateInfoOfTarget = (JSONObject) clienteTarget.get("private_info");
                Double balance = (Double) privateInfo.get("balance");
//                Double balanceOfTarget = (Double) privateInfoOfTarget.get("balance");

                if (amount < balance){
                    Withdraw(nomeUsu, amount);
                    Deposit(nomeTarget, amount);
                    return true;
                }
            }
        }
        return false;
    }
    public static double SeeBalance(String nome) {
        String caminhoCompleto = "projeto_mes_um/src/database/db.json";

        // Encontra o cliente pelo nome
        JSONObject cliente = FindClient(caminhoCompleto, nome);
        if (cliente != null) {
            // Atualiza o saldo
            JSONObject privateInfo = (JSONObject) cliente.get("private_info");
            Double balance = (Double) privateInfo.get("balance");
            return balance;
        }
        return 0.0;
    }

    //------------------------------------------//Client methods//-----------------------------------------------------//
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
        JSONObject client = FindClient("projeto_mes_um/src/database/db.json", name);
        return client;
    }

    //------------------------------------------//JSON methods//-----------------------------------------------------//

    public static String formatJson(String json) {
        int level = 0;
        StringBuilder formattedJson = new StringBuilder();
        for (char c : json.toCharArray()) {
            if (c == '[' || c == '{') {
                formattedJson.append(c).append("\n");
                level++;
                appendSpaces(formattedJson, level);
            } else if (c == ']' || c == '}') {
                formattedJson.append("\n");
                level--;
                appendSpaces(formattedJson, level);
                formattedJson.append(c);
            } else if (c == ',') {
                formattedJson.append(c).append("\n");
                appendSpaces(formattedJson, level);
            } else {
                formattedJson.append(c);
            }
        }
        return formattedJson.toString();
    }

    // Método para adicionar espaços de indentação JSON
    public static void appendSpaces(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append("  "); // Dois espaços por nível de indentação
        }
    }
}