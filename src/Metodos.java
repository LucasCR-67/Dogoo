import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {

    //METODO QUE LISTA OS PETS:
    public static void listarPets(ArrayList<Pet> pets) {
        System.out.println("===LISTA DE PETS===");
        for (int i = 0; i < pets.size(); i++) {
            Pet p = pets.get(i);
            System.out.println((i + 1) + " - " + p.getNome());
        }
    }

    public void cadastrarPet(Scanner scanner, ArrayList<Pet> pets) {

    }
}
