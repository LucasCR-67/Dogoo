import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {

    //METODOS DE LEITURA SEGURA: SEMPRE USAM nextLine E REPETEM SE O VALOR FOR INVÁLIDO
    public static int lerInt(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número inteiro.");
            }
        }
    }

    public static double lerDouble(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número (ex: 13.5).");
            }
        }
    }

    //METODO QUE LISTA OS PETS:
    public static void listarPets(ArrayList<Pet> pets) {
        System.out.println("===LISTA DE PETS===");
        for (int i = 0; i < pets.size(); i++) {
            Pet p = pets.get(i);
            System.out.println((i + 1) + " - " + p.getNome());
        }
    }

    //METODO QUE CADASTRA OS PETS:
    public static void cadastrarPet(Scanner scanner, ArrayList<Pet> pets) {
        System.out.print("Digite o nome do seu pet: ");
        String nomePet = scanner.nextLine();
        System.out.print(nomePet + " é cachorro, gato ou ave? (C/G/A): ");
        String tipoPet = scanner.nextLine().trim().toUpperCase();
        System.out.print("Qual a raça de " + nomePet + "?: ");
        String racaPet = scanner.nextLine();
        int idadePet = lerInt(scanner, "Qual a idade de " + nomePet + "? (anos): ");
        double pesoPet = lerDouble(scanner, "Qual o peso de " + nomePet + "? (Kg): ");

        Pet pet; //VARIÁVEL "pet" DO TIPO "Pet"

        //CRIAÇÃO DOS NOVOS OBJETOS: GATO OU CACHORRO
        if (tipoPet.equals("C")) {
            pet = new Cachorro(nomePet, idadePet, pesoPet, racaPet);
        } else if (tipoPet.equals("G")) {
            pet = new Gato(nomePet, idadePet, pesoPet, racaPet);
        } else if (tipoPet.equals("A")) {
            pet = new Ave(nomePet, idadePet, pesoPet, racaPet);
        } else {
            System.out.println("Tipo inválido.");
            return;
        }

        pets.add(pet);
        System.out.println(pet.getNome() + " cadastrado!");
        System.out.println("=====================================");
        System.out.println("===========DADOS DO ANIMAL===========");
        System.out.println("=====================================");
        System.out.println("NOME: " + pet.getNome());
        System.out.println("RAÇA: " + pet.getRaca());
        System.out.println("IDADE: " + pet.getIdade());
        System.out.println("PESO: " + pet.getPeso());
    }

    public static void escolherPet(Scanner scanner, ArrayList<Pet> pets) {
        if (pets.isEmpty()) {
            System.out.println("Nenhum pet cadastrado!");
            return;
        }

        System.out.println("                     ");
        int escolha = lerInt(scanner, "Escolha o pet pelo número: ");

        if (escolha < 1 || escolha > pets.size()) {
            System.out.println("Escolha de número inválida!");
            return;
        }

        Pet escolhido = pets.get(escolha - 1);

        //LINHA PARA MOSTRAR O ANIMAL ESCOLHIDO
        System.out.println("Animal escolhido - " + escolhido.getNome());

        if (escolhido instanceof Cachorro) {
            System.out.println("Opções para cachorro:");
            System.out.println("1 - Alimentar");
            System.out.println("2 - Banhar");
            System.out.println("3 - Passear");
            System.out.println("4 - Despesas de " + escolhido.getNome());

            System.out.print("Qual a opção você quer marcar para o seu cachorro? ");
            String opcaoCachorro = scanner.nextLine().trim();

            if (opcaoCachorro.equals("1")) {
                System.out.println(escolhido.getNome() + " alimentado!");
                System.out.println("Alimentar novamente " + escolhido.getNome() + " em 12 horas!");
            } else if (opcaoCachorro.equals("2")) {
                System.out.println(escolhido.getNome() + " tomou banho!");
                System.out.println("Dar banho em " + escolhido.getNome() + " em 1 semana!");
            } else if (opcaoCachorro.equals("3")) {
                System.out.println(escolhido.getNome() + " passeou!");
                System.out.println("Passear novamente com " + escolhido.getNome() + " em 12 horas!");
            } else if (opcaoCachorro.equals("4")) {

            } else {
                System.out.println("Escolha inválida.");
            }
        } else if (escolhido instanceof Gato) {
            System.out.println("Opções para gato:");
            System.out.println("1 - Alimentar");
            System.out.println("2 - Limpar caixa de areia");
            System.out.println("3 - Despesas de " + escolhido.getNome());

            System.out.print("Qual a opção você quer marcar para o seu gato? ");
            String opcaoGato = scanner.nextLine().trim();

            if (opcaoGato.equals("1")) {
                System.out.println(escolhido.getNome() + " alimentado!");
                System.out.println("Alimentar " + escolhido.getNome() + " novamente em 8 horas!");
            } else if (opcaoGato.equals("2")) {
                System.out.println("Caixa de areia limpa!");
                System.out.println("Limpar novamente mês que vem!");
            } else if (opcaoGato.equals("3")) {

            } else {
                System.out.println("Escolha inválida.");
            }
        } else if (escolhido instanceof Ave) {
            System.out.println("Opções para ave:");
            System.out.println("1 - Botar alpiste");
            System.out.println("2 - Botar água");
            System.out.println("3 - Limpar gaiola");
            System.out.println("4 - Despesas de " + escolhido.getNome());

            System.out.print("Qual a opção você quer marcar para o seu pássaro? ");
            String opcaoAve = scanner.nextLine().trim();

            if (opcaoAve.equals("1")) {
                System.out.println(escolhido.getNome() + " alimentado!");
                System.out.println("Alimentar " + escolhido.getNome() + " novamente em 8 horas!");
            } else if (opcaoAve.equals("2")) {
                System.out.println("Água de de " + escolhido.getNome() + " trocada!");
                System.out.println("Trocar água de " + escolhido.getNome() + " novamente em 4 horas!");
            } else if (opcaoAve.equals("3")) {
                System.out.println("Gaiola de " + escolhido.getNome() + " foi limpa!");
                System.out.println("Limpar gaiola de " + escolhido.getNome() + " novamente em 1 semana!");
            } else if (opcaoAve.equals("4")) {

            } else {
                System.out.println("Escolha inválida.");
            }
        }
    }

    public static void removerPet(Scanner scanner, ArrayList<Pet> pets) {
        int indice = lerInt(scanner, "Escolha o animal que você quer remover, pelo número na lista: ") - 1;

        if (indice >= 0 && indice < pets.size()) {
            Pet removido = pets.remove(indice);
            System.out.println(removido.getNome() + " foi removido da lista!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public static void adicionarPet(Scanner scanner, ArrayList<Pet> pets) {
        System.out.print("Digite o nome do seu pet: ");
        String nomePet = scanner.nextLine();
        System.out.print(nomePet + " é cachorro, gato ou ave? (C/G/A): ");
        String tipoPet = scanner.nextLine().trim().toUpperCase();
        System.out.print("Qual a raça de " + nomePet + "?: ");
        String racaPet = scanner.nextLine();
        int idadePet = lerInt(scanner, "Qual a idade de " + nomePet + "? (anos): ");
        double pesoPet = lerDouble(scanner, "Qual o peso de " + nomePet + "? (Kg): ");

        Pet pet;

        if (tipoPet.equals("C")) {
            pet = new Cachorro(nomePet, idadePet, pesoPet, racaPet);
        } else if (tipoPet.equals("G")) {
            pet = new Gato(nomePet, idadePet, pesoPet, racaPet);
        } else if (tipoPet.equals("A")) {
            pet = new Ave(nomePet, idadePet, pesoPet, racaPet);
        } else {
            System.out.println("Tipo inválido.");
            return;
        }

        pets.add(pet);
        System.out.println(pet.getNome() + " cadastrado!");
    }
}