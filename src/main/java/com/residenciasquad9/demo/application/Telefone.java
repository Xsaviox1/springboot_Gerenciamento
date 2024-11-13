package app;

public class Telefone {
    
    private int idTelefone;
    private String numero;
    private String tipoTelefone;
    private String ddd;

    // Construtor sem argumentos
    public Telefone() {}

    // Construtor com argumentos
    public Telefone(int idTelefone, String numero, String tipoTelefone, String ddd) {
        this.idTelefone = idTelefone;
        this.numero = numero;
        this.tipoTelefone = tipoTelefone;
        this.ddd = ddd;
    }

    // Getters e Setters
    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    // Método para obter o telefone completo
    public String getTelefoneCompleto() {
        return "(" + ddd + ") " + numero;
    }

    // Método para verificar se o número é válido (exemplo: 8 ou 9 dígitos)
    public boolean isNumeroValido() {
        return numero != null && numero.matches("\\d{8,9}");
    }

    // Método para atualizar o telefone
    public void atualizarTelefone(String numero, String ddd, String tipoTelefone) {
        this.numero = numero;
        this.ddd = ddd;
        this.tipoTelefone = tipoTelefone;
    }
}
