import java.util.Scanner;

public class ConsoleVeiculos {
    private static Veiculos locadora = new Veiculos();
    private static Scanner scanner = new Scanner(System.in);

    public static  void exibeMenuVeiculos() {
        int opcao = 0;

        do {
            System.out.println("Sistema de Cadastro de Veículos");
            System.out.println("1 - Incluir Veículo");
            System.out.println("2 - Alterar Veículo");
            System.out.println("3 - Capturar Veículo");
            System.out.println("4 - Listar Veículos");
            System.out.println("0 - Voltar Menu Anterior");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    incluirVeiculo();
                    break;
                case 2:
                    alterarVeiculo();
                    break;
                case 3:
                    capturarVeiculos();
                    break;
                case 4:
                    listarVeiculos();
                    break;
                case 0:
                    LocadoraVeiculosConsole.exibirMenuLocadoraVeic();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    /**
     * 
     */
    private static void incluirVeiculo() {
        System.out.println("Inclusão de Veículo");
    
        System.out.print("Placa: ");
        String placa = scanner.next();
    
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
    
        System.out.print("Valor Diária: ");
        double valorDiaria = scanner.nextDouble();
    
        System.out.println("Tipo do Veículo");
        System.out.println("1 - Carro");
        System.out.println("2 - Ônibus");
        System.out.print("Escolha uma opção: ");
        int tipo = scanner.nextInt();
    
        Veiculo veiculo;
    
        if (tipo == 1) {
            System.out.print("Média de km por litros: ");
            double mediaKmPorLitros = scanner.nextDouble();
        
            System.out.print("Ar condicionado (S/N): ");
            boolean arCondicionado = scanner.next().equalsIgnoreCase("S");
        
            veiculo = new Carro(placa, ano, valorDiaria, mediaKmPorLitros, arCondicionado);
        } else if (tipo == 2) {
            System.out.print("Número de passageiros: ");
            int numPassageiros = scanner.nextInt();
        
            System.out.print("Categoria: ");
            String categoria = scanner.next();
        
            veiculo = new Onibus(placa, ano, valorDiaria, numPassageiros, categoria);
        } else {
            System.out.println("Tipo de veículo inválido!");
            return;
        }
        
        locadora.add(veiculo);
        System.out.println("Veículo incluído com sucesso!");
    }    
    
    private static void alterarVeiculo() {
        System.out.println("Alteração de Veículo");
    
        System.out.print("Placa: ");
        String placa = scanner.next();
    
        if (!locadora.existe(placa)) {
            System.out.println("Veículo não encontrado!");
            return;
        }
    
        Veiculo veiculo = locadora.get(placa);
    
        System.out.print("Ano (" + veiculo.getAno() + "): ");
        int ano = scanner.nextInt();
        veiculo.setAno(ano);
    
        System.out.print("Valor Diária (" + veiculo.getValorDiaria() + "): ");
        double valorDiaria = scanner.nextDouble();
        veiculo.setValorDiaria(valorDiaria);
    
        if (veiculo instanceof Carro) {
            Carro carro = (Carro) veiculo;
    
            System.out.print("Média de km por litros (" + carro.getMediaKmPorLitro() + "): ");
            double mediaKmPorLitros = scanner.nextDouble();
            carro.setMediaKmPorLitro(mediaKmPorLitros);
    
            System.out.print("Ar Condicionado (" + carro.isArCondicionado() + "): ");
        boolean arCondicionado = scanner.nextBoolean();
        carro.setArCondicionado(arCondicionado);

    } else if (veiculo instanceof Onibus) {
        Onibus onibus = (Onibus) veiculo;

        System.out.print("Número de passageiros (" + onibus.getNumeroPassageiros() + "): ");
        int numPassageiros = scanner.nextInt();
        onibus.setNumeroPassageiros(numPassageiros);

        System.out.print("Categoria (" + onibus.getCategoria() + "): ");
        String categoria = scanner.next();
        onibus.setCategoria(categoria);
    }

    boolean alterado = locadora.set(placa, veiculo);
    if (alterado) {
        System.out.println("Veículo alterado com sucesso!");
    } else {
        System.out.println("Não foi possível alterar o veículo.");
    }
} 
    
    private static void capturarVeiculos() {
        System.out.println("Captura de Veículos");
    
        System.out.print("Placas (separadas por vírgula): ");
        String placasStr = scanner.next();
        String[] placas = placasStr.split(",");
    
        for (String placa : placas) {
            if (locadora.existe(placa)) {
                System.out.println(locadora.getInfo(placa));
            } else {
                System.out.println("Veículo com placa " + placa + " não encontrado.");
            }
        }
    }
    
    private static void listarVeiculos() {
        System.out.println("Lista de Veículos");
    
        String info = locadora.getInfo();
        if (info != null) {
            System.out.println(info);
        } else {
            System.out.println("Nenhum veículo cadastrado.");
        }
    }

   
}    
