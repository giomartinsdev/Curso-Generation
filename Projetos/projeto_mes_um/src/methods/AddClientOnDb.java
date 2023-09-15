// Importações necessárias para o funcionamento do código
package methods;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Classe que contém o método para adicionar o cliente no arquivo JSON
public class AddClientOnDb extends Client {

    // Método para adicionar o cliente na DB JSON
    @SuppressWarnings("unchecked")
    public static void adClient(String caminhoArquivo, JSONObject novoCliente) {
        //convertedor de json
        JSONParser parser = new JSONParser();

        try {
            // Obter o caminho atual do diretório
            String diretorioAtual = new File(".").getCanonicalPath();
            // Combinar o caminho do arquivo com o caminho atual
            String caminhoCompleto = diretorioAtual + "/" + caminhoArquivo;

            // Criar um leitor de arquivos pro arquivo que foi especificado acima
            try (FileReader reader = new FileReader(caminhoCompleto)) {
                //utiliza o convertedor e o reader para pegar o arquivo e por num obj
                Object obj = parser.parse(reader);

                // Verificar se o arquivo está vazio ou não contém um objeto JSON
                if (obj == null) {
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.add(novoCliente);

                    // Escrever o cliente que está na variavel jsonarray no JSON
                    try (FileWriter file = new FileWriter(caminhoCompleto)) {
                        file.write(formatJson(jsonArray.toJSONString()));
                        file.flush();
                    }
                } else {
                    // Caso o arquivo n~ao seja nulo
                    JSONArray jsonArray = (JSONArray) obj;
                    jsonArray.add(novoCliente);

                    // Escrever o JSON no arquivo formatado
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

}