public class Cachorro extends Pet {

    public Cachorro(String nome, int idade, double peso, String raca)
    {
        super(nome, idade, peso, raca);
    }

    public void passear() {
        System.out.println(getNome() + " está passeando!");
    }
}