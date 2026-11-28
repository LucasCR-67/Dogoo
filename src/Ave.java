public class Ave extends Pet {

    public Ave(String nome, int idade, double peso, String raca)
    {
        super(nome, idade, peso, raca);
    }

    public void limparGaiola() {
        System.out.println("Gaiola " + getNome() + " está limpa!");
    }

}
