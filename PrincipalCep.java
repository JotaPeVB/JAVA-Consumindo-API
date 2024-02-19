package Desafio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalCep {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Cep> listaDeCep = new ArrayList<>();

        while (!busca.equalsIgnoreCase("Sair")) {
            System.out.println("Se você deseja adicionar mais um CEP digite o número, caso contrário digite Sair");

            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("Sair")){
                break;
            }

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://viacep.com.br/ws/" + busca + "/json/"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            CepAPI cepAPI = gson.fromJson(response.body(), CepAPI.class);

            Cep cep = new Cep(cepAPI);

            listaDeCep.add(cep);
        }

        FileWriter escrita = new FileWriter("cep.json");
        escrita.write(gson.toJson(listaDeCep));
        escrita.close();
    }
}
