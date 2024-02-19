package Desafio;

public class Cep {
    private String cep;
    private String lougradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private int ddd;

    public Cep(CepAPI cepAPI) {
        this.cep = cepAPI.cep();
        this.bairro = cepAPI.bairro();
        this.uf = cepAPI.uf();
        this.lougradouro = cepAPI.lougradouro();
        this.complemento = cepAPI.complemento();
        this.localidade = cepAPI.localidade();
        this.ddd = cepAPI.ddd();
    }

    public String getCep() {
        return cep;
    }

    public String getLougradouro() {
        return lougradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public int getDdd() {
        return ddd;
    }
}
