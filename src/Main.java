import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pet> pets = new ArrayList<>(); // "pets" É O NOME DA LISTA
        pets.add(new Cachorro("Fiuk", 4, 13.0, "Shitzu"));
        pets.add(new Gato("Félix", 6, 13.0, "Persa"));

//LOOPING PARA CADASTRAR NÚMERO I DE ANIMAIS:
        String opcao = ""; //VARÍAVEL OPCAO QUE TEM QUE SER CRIADA FORA DO LOOP
        String opcaoMenu = "1";

        do {
            //TÍTULO QUE SÓ APARECE QUANDO O USUÁRIO ESCOLHEU CADASTRAR MAIS:
            if (opcao.equals("2")) {
                System.out.println("===NOVO CADASTRO===");
            }

            //CADASTRO DOS PETS COM SUAS CARACTERÍSTICAS:
            System.out.print("Digite o nome do seu pet: ");
            String nomePet = scanner.nextLine();
            System.out.print(nomePet + " é cachorro ou gato? (C/G): ");
            String tipoPet = scanner.nextLine().toUpperCase();
            System.out.print("Qual a raça de " + nomePet + "?: ");
            String racaPet = scanner.nextLine();
            System.out.print("Qual a idade de " + nomePet + "? (anos): ");
            int idadePet = scanner.nextInt();
            System.out.print("Qual o peso de " + nomePet + "? (Kg): ");
            double pesoPet = scanner.nextDouble();
            scanner.nextLine();

            Pet pet; //VARIÁVEL "pet" DO TIPO "Pet"

//CRIAÇÃO DOS NOVOS OBJETOS: GATO OU CACHORRO
            if (tipoPet.equals("C")) {
                pet = new Cachorro(nomePet, idadePet, pesoPet, racaPet);
                pets.add(pet);
                System.out.println(pet.getNome() + " cadastrado!");
                System.out.println("=====================================");
                System.out.println("===========DADOS DO ANIMAL===========");
                System.out.println("=====================================");
                System.out.println("NOME: " + pet.getNome());
                System.out.println("RAÇA: " + pet.getRaca());
                System.out.println("IDADE: " + pet.getIdade());
                System.out.println("PESO: " + pet.getPeso());
            } else if (tipoPet.equals("G")) {
                pet = new Gato(nomePet, idadePet, pesoPet, racaPet);
                pets.add(pet);
                System.out.println(pet.getNome() + " cadastrado!");
                System.out.println("=====================================");
                System.out.println("===========DADOS DO ANIMAL===========");
                System.out.println("=====================================");
                System.out.println("NOME: " + pet.getNome());
                System.out.println("RAÇA: " + pet.getRaca());
                System.out.println("IDADE: " + pet.getIdade());
                System.out.println("PESO: " + pet.getPeso());
            } else {
                System.out.println("Tipo inválido.");
            }

//LINHA QUE QUESTIONA SE O USUÁRIO QUER FINALIZAR O LOOP OU PROSSEGUIR E CADASTRAR MAIS ANIMAIS:
            System.out.println("Tecle: 1 para prosseguir, ou 2 para cadastrar mais pets!");
            opcao = scanner.nextLine();

        } while (opcao.equals("2"));

//LOOP DO MENU: LISTAR, ALTERAR A LISTA, ESCOLHER E FAZER AÇÕES
        do {
            System.out.println("===LISTA DE PETS===");
            for (int i = 0; i < pets.size(); i++) {
                Pet p = pets.get(i);
                System.out.println((i + 1) + " - " + p.getNome());
            }

            System.out.print("Antes de continuarmos, você deseja alterar a lista, removendo ou adicionando algum pet? (S/N): ");
            String escolhaDelete = scanner.nextLine().toUpperCase();

            if (escolhaDelete.equals("S")) {
                System.out.print("Você deseja remover ou adicionar pets na lista? (R/A): ");
                String escolhaLista = scanner.nextLine().toUpperCase();

                if (escolhaLista.equals("R")) {
                    System.out.print("Escolha o animal que você quer remover, pelo número na lista: ");
                    int indice = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (indice >= 0 && indice < pets.size()) {
                        Pet removido = pets.remove(indice);
                        System.out.println(removido.getNome() + " foi removido da lista!");
                    } else {
                        System.out.println("Índice inválido!");
                    }
                } else if (escolhaLista.equals("A")) {
                    System.out.print("Digite o nome do seu pet: ");
                    String nomePet = scanner.nextLine();
                    System.out.print(nomePet + " é cachorro ou gato? (C/G): ");
                    String tipoPet = scanner.nextLine().toUpperCase();
                    System.out.print("Qual a raça de " + nomePet + "?: ");
                    String racaPet = scanner.nextLine();
                    System.out.print("Qual a idade de " + nomePet + "? (anos): ");
                    int idadePet = scanner.nextInt();
                    System.out.print("Qual o peso de " + nomePet + "? (Kg): ");
                    double pesoPet = scanner.nextDouble();
                    scanner.nextLine();

                    Pet pet;

                    if (tipoPet.equals("C")) {
                        pet = new Cachorro(nomePet, idadePet, pesoPet, racaPet);
                        pets.add(pet);
                        System.out.println(pet.getNome() + " cadastrado!");
                    } else if (tipoPet.equals("G")) {
                        pet = new Gato(nomePet, idadePet, pesoPet, racaPet);
                        pets.add(pet);
                        System.out.println(pet.getNome() + " cadastrado!");
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                } else {
                    System.out.println("Opção inválida.");
                }

                System.out.println("===NOVA LISTA===");
                for (int i = 0; i < pets.size(); i++) {
                    Pet p = pets.get(i);
                    System.out.println((i + 1) + " - " + p.getNome());
                }
            }

            System.out.println("                     ");
            System.out.print("Escolha o pet pelo número: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha < 1 || escolha > pets.size()) {
                System.out.println("Escolha de número inválida!");
            } else {
                Pet escolhido = pets.get(escolha - 1);

//LINHA PARA MOSTRAR O ANIMAL ESCOLHIDO
                System.out.println("Animal escolhido - " + escolhido.getNome());

                if (escolhido instanceof Cachorro) {
                    System.out.println("Opções para cachorro:");
                    System.out.println("1 - Alimentar");
                    System.out.println("2 - Banhar");
                    System.out.println("3 - Passear");

                    System.out.print("Qual a opção você quer marcar para o seu cachorro? ");
                    String opcaoCachorro = scanner.nextLine();

                    if (opcaoCachorro.equals("1")) {
                        System.out.println(escolhido.getNome() + " alimentado!");
                        System.out.println("Alimentar novamente " + escolhido.getNome() + " em 12 horas!");
                    } else if (opcaoCachorro.equals("2")) {
                        System.out.println(escolhido.getNome() + " tomou banho!");
                        System.out.println("Dar banho em " + escolhido.getNome() + " em 1 semana!");
                    } else if (opcaoCachorro.equals("3")) {
                        System.out.println(escolhido.getNome() + " passeou!");
                        System.out.println("Passear novamente com " + escolhido.getNome() + " em 12 horas!");
                    } else {
                        System.out.println("Escolha inválida.");
                    }
                } else { //GATO
                    System.out.println("Opções para gato:");
                    System.out.println("1 - Alimentar");
                    System.out.println("2 - Limpar caixa de areia");

                    System.out.print("Qual a opção você quer marcar para o seu gato? ");
                    String opcaoGato = scanner.nextLine();

                    if (opcaoGato.equals("1")) {
                        System.out.println(escolhido.getNome() + " alimentado!");
                        System.out.println("Alimentar " + escolhido.getNome() + " novamente em 8 horas!");
                    } else if (opcaoGato.equals("2")) {
                        System.out.println("Caixa de areia limpa!");
                        System.out.println("Limpar novamente mês que vem!");
                    } else {
                        System.out.println("Escolha inválida.");
                    }
                }

                System.out.println("Tecle: 1 para voltar ao menu, ou 2 para finalizar o programa!");
                opcaoMenu = scanner.nextLine();
            }

        } while (opcaoMenu.equals("1"));
    }
}