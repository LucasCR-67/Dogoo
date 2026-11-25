public class Pet {
    private String nome;
    private int idade;
    private double peso;
    private String raca;

    //CONSTRUTOR
    public Pet(String nome, int idade, double peso, String raca) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    //GETTERS
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public double getPeso() { return peso; }
    public String getRaca() { return raca; }
}