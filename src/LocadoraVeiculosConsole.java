import java.util.Scanner;

public class LocadoraVeiculosConsole {
    ConsoleCliente conCliente;
    ConsoleLocadora conLocadora;
    LocacoesConsole conLocacoes;
    

   


    public void exibirMenuLocadoraVeic() {
        Scanner scan = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Locadora");
            System.out.println("2. Clientes");
            System.out.println("3. Locação");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scan.nextInt();
            scan.nextLine(); // consome a quebra de linha deixada pelo nextInt()

            switch (opcao) {
                case 1:
                    conLocadora.exibirMenuPrincipal();
                    break;
                case 2:
                    conCliente.exibirMenuPrincipal();
                    break;
                case 3:
                    conLocacoes.exibirMenuPrincipal();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }
    }

}
