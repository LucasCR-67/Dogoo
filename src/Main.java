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
           Metodos.cadastrarPet(scanner, pets);

//LINHA QUE QUESTIONA SE O USUÁRIO QUER FINALIZAR O LOOP OU PROSSEGUIR E CADASTRAR MAIS ANIMAIS:
            System.out.println("Tecle: 1 para prosseguir, ou 2 para cadastrar mais pets!");
            opcao = scanner.nextLine();

        } while (opcao.equals("2"));

//LOOP DO MENU: LISTAR, ALTERAR A LISTA, ESCOLHER E FAZER AÇÕES
        do {
            Metodos.listarPets(pets); //METODO QUE LISTA OS ANIMAIS RECEBIDOS

            System.out.print("Antes de continuarmos, você deseja alterar a lista, removendo ou adicionando algum pet? (S/N): ");
            String escolhaDelete = scanner.nextLine().toUpperCase();

            if (escolhaDelete.equals("S")) {
                System.out.print("Você deseja remover ou adicionar pets na lista? (R/A): ");
                String escolhaLista = scanner.nextLine().toUpperCase();

                if (escolhaLista.equals("R")) {
                    Metodos.removerPet(scanner, pets);

                } else if (escolhaLista.equals("A")) {
                    Metodos.adicionarPet(scanner, pets);
                }

                System.out.println("===NOVA LISTA===");
                Metodos.listarPets(pets); //METODO QUE LISTA OS ANIMAIS RECEBIDOS
            }

            Metodos.esoolherPet(scanner, pets);

            System.out.println("Tecle: 1 para voltar ao menu, ou 2 para finalizar o programa!");
            opcaoMenu = scanner.nextLine();

        }while (opcaoMenu.equals("1"));

        System.out.print("Muito obrigado por usar Dogoo e confiar nessa aplicação a rotina dos seus pets! ;)");
    }
}