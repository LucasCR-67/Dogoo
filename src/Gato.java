public class Gato extends Pet {

    public Gato(String nome, int idade, double peso, String raca)
    {
        super(nome, idade, peso, raca);
    }

    public void limparCaixaDeAreia() {
        System.out.println("Caixa de areia do " + getNome() + " limpa!");
    }
}