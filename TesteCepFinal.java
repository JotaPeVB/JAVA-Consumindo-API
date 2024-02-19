package Desafio;

import java.util.Scanner;

public class TesteCepFinal {

    public static void main(String[] args) {
        Gerador gerador = new Gerador();
        Scanner leitura = new Scanner(System.in);
        String busca = "";

        System.out.println("Seja bem-vindo ao consulta Cep");

        while (!busca.equalsIgnoreCase("2")){
            System.out.println("Digite 1 para inserir um CEP");
            System.out.println("Digite 2 para Sair e gerar suas lista com CEPS");

            busca = leitura.next();

            switch (busca){
                case "1":
                    var cep = leitura.next();

                    BuscaCep buscaCep = new BuscaCep();
                    buscaCep.buscaCepinho(cep);
                    gerador.geraObjetoCep(buscaCep);
                    break;

                case "2":
                    gerador.geraJson();
            }
        }
        System.out.println("Programa finalizado, lista gerada com sucesso");
    }
}
