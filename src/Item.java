public class Item {
    String tipo;
    String nome;
    double preco;

    public Item (String tipo, String nome, double preco) {
        this.tipo = tipo;
        this.nome = nome;
        this.preco = preco;
    }

    public static void addItem() {

    }

    //GETTERS E SETTERS:
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String t) {
        this.tipo = tipo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}