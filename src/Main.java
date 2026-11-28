import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuNovo;
        ArrayList<Pet> pets = new ArrayList<>(); // "pets" É O NOME DA LISTA
        pets.add(new Cachorro("Fiuk", 4, 13.0, "Shitzu"));
        pets.add(new Gato("Félix", 6, 13.0, "Persa"));
//        Item.add(new Gaiola("Gaiola grande de metal", "Gaiola 3000", 200.0));

//LOOPING PRINCIPAL:
        do {
            System.out.println("MENU INICIAL");
            System.out.println("1 - CADASTRO");
            System.out.println("2 - PETS");
            System.out.println("3 - DESPESAS");
            System.out.println("4 - FECHAR SISTEMA");
            System.out.println("");
            System.out.println("===O QUE VOCÊ DESEJA FAZER HOJE?===");
            menuNovo = Metodos.lerInt(scanner, "> ");

//LOOPING PARA CADASTRAR NÚMERO I DE ANIMAIS:
            String opcao = ""; //VARÍAVEL OPCAO QUE TEM QUE SER CRIADA FORA DO LOOP

            if (menuNovo == 1) {
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

//FLUXO DEPOIS DO CADASTRO (1 = PROSSEGUIR): LISTAR, ALTERAR A LISTA, ESCOLHER E FAZER AÇÕES
                Metodos.listarPets(pets);

                System.out.print("Antes de continuarmos, você deseja alterar a lista, removendo ou adicionando algum pet? (S/N): ");
                String escolhaDelete = scanner.nextLine().trim().toUpperCase();

                if (escolhaDelete.equals("S")) {
                    System.out.print("Você deseja remover ou adicionar pets na lista? (R/A): ");
                    String escolhaLista = scanner.nextLine().trim().toUpperCase();

                    boolean alterou = false; // SÓ MOSTRA A NOVA LISTA SE ALGO MUDOU

                    if (escolhaLista.equals("R")) {
                        Metodos.removerPet(scanner, pets);
                        alterou = true;
                    } else if (escolhaLista.equals("A")) {
                        Metodos.adicionarPet(scanner, pets);
                        alterou = true;
                    }

                    if (alterou) {
                        System.out.println("===NOVA LISTA===");
                        Metodos.listarPets(pets);
                    }
                }

                Metodos.escolherPet(scanner, pets);

                System.out.println("Tecle: 1 para voltar ao menu, ou 2 para finalizar o programa!");
                if (scanner.nextLine().trim().equals("2")) {
                    menuNovo = 4; // faz o loop principal terminar
                }

//MENU PETS (OPÇÃO 2 DIRETO): LISTA E PERGUNTA SE QUER FAZER ALGUMA AÇÃO
            } else if (menuNovo == 2) {
                Metodos.listarPets(pets);

                System.out.print("Você deseja fazer alguma ação com algum desses pets? (S/N): ");
                String querAcao = scanner.nextLine().trim().toUpperCase();

                if (querAcao.equals("S")) {
                    Metodos.escolherPet(scanner, pets);
                }
                // SE FOR N (OU OUTRA COISA), SÓ VOLTA PARA O MENU INICIAL

            } else if (menuNovo == 3) {
                System.out.println("===MENU DE DESPESAS DO SEU PET===");


            } else if (menuNovo != 4) {
                System.out.println("Sistema finalizando!");
                break;
            }

        } while (menuNovo != 4);

        System.out.print("Muito obrigado por usar Dogoo e confiar nessa aplicação a rotina dos seus pets! ;)");
    }
}