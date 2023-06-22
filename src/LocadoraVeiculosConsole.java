import java.util.Scanner;

import clienteexcecao.ClienteExistenteException;
import clienteexcecao.ClienteNaoEncontradoException;
import veiculosececao.ColecaoVaziaException;
import veiculosececao.VeiculoExistenteException;
import veiculosececao.VeiculoNaoEncontradoException;

public class LocadoraVeiculosConsole {
    static ConsoleLocacoes locacoes;
    

    public static void exibirMenuLocadoraVeic() throws ClienteNaoEncontradoException, VeiculoNaoEncontradoException, ClienteExistenteException, VeiculoExistenteException, ColecaoVaziaException {
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
                    ConsoleVeiculos.exibeMenuVeiculos();
                    break;
                case 2:
                    ConsoleClientes.exibeMenuCliente();
                    break;
                case 3:
                    locacoes.exibeMenuLocacoes();
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
