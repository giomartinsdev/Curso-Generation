package methods;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Classe abstrata Client implements an interface DefaultMethods
public abstract class Client implements DefaultMethods {

    // Atributos da classe
    private String name;
    private String surname;
    private String age;
    private double balance;
    private String password;

    // Construtores da classe
    public Client(String name, String surname, String age, double balance, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.balance = balance;
        this.password = password;
    }

    public Client() {
    }

    // Getters e Setters dos atributos
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // Implementação dos métodos relacionados ao balanço
    @Override
    public boolean deposit(String customerName, double amount) {
        JSONParser parser = new JSONParser();

        try {
            String fullPath = "projeto_mes_um/src/database/db.json";
            JSONObject client = findClient(fullPath, name);

            if (client != null) {
                JSONObject privateInfo = (JSONObject) client.get("private_info");
                double currentBalance = (double) privateInfo.get("balance");
                double newBalance = currentBalance + amount;
                privateInfo.put("balance", newBalance);

                Object obj = parser.parse(new FileReader(fullPath));
                JSONArray clients = (JSONArray) obj;

                for (Object clientObj : clients) {
                    JSONObject currentClient = (JSONObject) clientObj;
                    JSONObject publicInfo = (JSONObject) currentClient.get("public_info");
                    String clientName = (String) publicInfo.get("name");

                    if (clientName.equalsIgnoreCase(name)) {
                        currentClient.put("private_info", privateInfo);
                        break;
                    }
                }

                try (FileWriter file = new FileWriter(fullPath)) {
                    String formattedJson = formatJson(clients.toString());
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

        return false;
    }

    // Withdraw method
    @Override
    public boolean withdraw(String name, double amount) {
        JSONParser parser = new JSONParser();

        try {
            String fullPath = "projeto_mes_um/src/database/db.json";
            JSONObject client = findClient(fullPath, name);

            if (client != null) {
                JSONObject privateInfo = (JSONObject) client.get("private_info");
                double currentBalance = (double) privateInfo.get("balance");

                if (amount <= currentBalance) {
                    double newBalance = currentBalance - amount;
                    privateInfo.put("balance", newBalance);

                    Object obj = parser.parse(new FileReader(fullPath));
                    JSONArray clients = (JSONArray) obj;

                    for (Object clientObj : clients) {
                        JSONObject currentClient = (JSONObject) clientObj;
                        JSONObject publicInfo = (JSONObject) currentClient.get("public_info");
                        String clientName = (String) publicInfo.get("name");

                        if (clientName.equalsIgnoreCase(name)) {
                            currentClient.put("private_info", privateInfo);
                            break;
                        }
                    }

                    try (FileWriter file = new FileWriter(fullPath)) {
                        String formattedJson = formatJson(clients.toString());
                        file.write(formattedJson);
                        file.flush();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        return false;
    }

    // transfer method
    public boolean transfer(String targetName, String sourceName, Double amount) {
        String fullPath = "projeto_mes_um/src/database/db.json";
        JSONObject sourceClient = findClient(fullPath, sourceName);
        JSONObject targetClient = findClient(fullPath, targetName);

        if (sourceClient != null && targetClient != null) {
            JSONObject sourcePrivateInfo = (JSONObject) sourceClient.get("private_info");
            double sourceBalance = (double) sourcePrivateInfo.get("balance");

            if (amount <= sourceBalance) {
                boolean withdrawSuccess = withdraw(sourceName, amount);
                boolean depositSuccess = deposit(targetName, amount);

                if (withdrawSuccess && depositSuccess) {
                    return true;
                } else {
                    // Se a transferência falhar, reverter a operação
                    deposit(sourceName, amount);
                    withdraw(targetName, amount);
                }
            }
        }
        return false;
    }

    // SeeBalance method
    @Override
    public double getBalance(String name) {
        String fullPath = "projeto_mes_um/src/database/db.json";
        JSONObject client = findClient(fullPath, name);

        if (client != null) {
            JSONObject privateInfo = (JSONObject) client.get("private_info");
            return (double) privateInfo.get("balance");
        }

        return 0.0;
    }

    // Métodos para manipular o banco de dados JSON relacionados ao cliente
    @SuppressWarnings("unchecked")
    public static void addClient(String caminhoArquivo, JSONObject novoCliente) {
        JSONParser parser = new JSONParser();

        try {
            String diretorioAtual = new File(".").getCanonicalPath();
            String caminhoCompleto = diretorioAtual + "/" + caminhoArquivo;

            try (FileReader reader = new FileReader(caminhoCompleto)) {
                Object obj = parser.parse(reader);

                if (obj == null) {
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.add(novoCliente);

                    try (FileWriter file = new FileWriter(caminhoCompleto)) {
                        file.write(formatJson(jsonArray.toJSONString()));
                        file.flush();
                    }
                } else {
                    JSONArray jsonArray = (JSONArray) obj;
                    jsonArray.add(novoCliente);

                    try (FileWriter file = new FileWriter(caminhoCompleto)) {
                        file.write(formatJson(jsonArray.toJSONString()));
                        file.flush();
                    }
                }
            } catch (IOException | org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject findClient(String caminhoArquivo, String nome) {
        JSONParser parser = new JSONParser();

        try {
            String diretorioAtual = new File(".").getCanonicalPath();
            String caminhoCompleto = diretorioAtual + "/" + caminhoArquivo;

            try (FileReader reader = new FileReader(caminhoCompleto)) {
                Object obj = parser.parse(reader);
                JSONArray clientes = (JSONArray) obj;

                for (Object clientObj : clientes) {
                    JSONObject client = (JSONObject) clientObj;
                    JSONObject publicInfo = (JSONObject) client.get("public_info");
                    String clientName = (String) publicInfo.get("name");

                    if (clientName.equalsIgnoreCase(nome)) {
                        return client;
                    }
                }
            } catch (IOException | org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static JSONObject loginMethod(String name, String pass) {
        JSONObject client = findClient("projeto_mes_um/src/database/db.json", name);
        return client;
    }

    // Métodos de apoio para formatação JSON
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
    public static void appendSpaces(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append("  ");
        }
    }

    // Método para representar o objeto como uma "string"
    @Override
    public String toString() {
        return """
        Usuario:

        First name: """ + this.getName() + """

        Surname: """ + this.getSurname() + """

        Age: """ + this.getAge() + """

        Password: """ + this.getPassword();
    }

}
