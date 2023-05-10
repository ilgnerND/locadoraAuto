
import java.util.Scanner;

public class LocadoraVeiculosConsole {
    Veiculos veiculos = new Veiculos();
    GerenciadorClientes clientes = new GerenciadorClientes(); 
    Locacoes locacoes = new Locacoes();
    ConsoleVeiculos consoleVeiculos = new ConsoleVeiculos(veiculos);
    ConsoleClientes consoleClientes = new ConsoleClientes(clientes);
    ConsoleLocacoes consoleLocacoes = new ConsoleLocacoes(clientes, veiculos);
    

    public void exibirMenuLocadoraVeic() {
        Scanner scan = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Veiculos");
            System.out.println("2. Clientes");
            System.out.println("3. Locação");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scan.nextInt();
            scan.nextLine(); // consome a quebra de linha deixada pelo nextInt()

            switch (opcao) {
                case 1:
                    consoleVeiculos.exibeMenuVeiculos();
                    break;
                case 2:
                    consoleClientes.exibeMenuCliente();
                    break;
                case 3:
                    consoleLocacoes.exibeMenuLocacoes();
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
