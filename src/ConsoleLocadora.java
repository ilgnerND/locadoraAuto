import java.util.Scanner;

public class ConsoleLocadora {
    private IVeiculos locadora;
    private Scanner scanner;
    Veiculo veiculo;

    
    
    /**
     * 
     */
    public void exibirMenuPrincipal() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Cadastro de veiculo");
            System.out.println("2. Consulta de veiculo");
            System.out.println("3. Alteracao de veiculo");
            System.out.println("4. Remocao de veiculo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consome a quebra de linha deixada pelo nextInt()
            
            switch (opcao) {
                case 1:
                    exibirMenuCadastro();
                    break;
                case 2:
                    exibirMenuConsulta();
                    break;
                case 3:
                    exibirMenuAlteracao();
                    break;
                case 4:
                    exibirMenuRemocao();
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
    
    /**
     * 
     */
    public void exibirMenuCadastro() {
        System.out.println("=== CADASTRO DE VEICULO ===");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // consome a quebra de linha deixada pelo nextInt()
        System.out.print("Valor da diaria: ");
        double valorDiaria = scanner.nextDouble();
        scanner.nextLine(); // consome a quebra de linha deixada pelo nextDouble()
        System.out.print("Tipo de veiculo (1 - Carro, 2 - Onibus): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // consome a quebra de linha deixada pelo nextInt()
    
        Veiculo veiculo = null;
        if (tipo == 1) {
            System.out.print("Media de km por litro: ");
            double mediaKmPorLitro = scanner.nextDouble();
            scanner.nextLine(); // consome a quebra de linha deixada pelo nextDouble()
            System.out.print("Ar condicionado (S/N): ");
            boolean arCondicionado = scanner.nextLine().equalsIgnoreCase("S");
            veiculo = new Carro(placa, ano, valorDiaria, mediaKmPorLitro, arCondicionado);
        } else if (tipo == 2) {
            System.out.print("Numero de passageiros: ");
            int numeroPassageiros = scanner.nextInt();
            scanner.nextLine(); // consome a quebra de linha deixada pelo nextInt()
            System.out.print("Categoria: ");
            String categoria = scanner.nextLine();
            veiculo = new Onibus(placa, ano, valorDiaria, numeroPassageiros, categoria);
        }
    
        locadora.add(veiculo);
        System.out.println("Veiculo cadastrado com sucesso!");
    }
    
    /**
     * 
     */
    public void exibirMenuConsulta() {
        System.out.println("=== CONSULTA DE VEICULO ===");
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        
         veiculo = locadora.get(placa);
        if (veiculo == null) {
            System.out.println("Veiculo nao encontrado!");
        } else {
            System.out.println(((IVeiculos) veiculo).getInfo());
        }
    }
    
    /**
     * 
     */
    public void exibirMenuAlteracao() {
        System.out.println("=== ALTERACAO DE VEICULO ===");
        System.out.print("Placa do veiculo a ser alterado: ");
        String placa = scanner.nextLine();
        Veiculo veiculoAtual = locadora.get(placa);
        if (veiculoAtual == null) {
            System.out.println("Veiculo nao encontrado!");
            return;
        }
        System.out.print("Nova placa (deixe em branco para manter o valor atual '" + veiculoAtual.getPlaca() + "'): ");
        String novaPlaca = scanner.nextLine();
        if (!novaPlaca.isBlank()) {
            veiculoAtual.setPlaca(novaPlaca);
        }
        System.out.print("Novo ano (deixe em branco para manter o valor atual '" + veiculoAtual.getAno() + "'): ");
        String novoAnoStr = scanner.nextLine();
        if (!novoAnoStr.isBlank()) {
            int novoAno = Integer.parseInt(novoAnoStr);
            veiculoAtual.setAno(novoAno);
        }
        System.out.print("Novo valor da diaria (deixe em branco para manter o valor atual '" + veiculoAtual.getValorDiaria() + "'): ");
        String novoValorDiariaStr = scanner.nextLine();
        if (!novoValorDiariaStr.isBlank()) {
            double novoValorDiaria = Double.parseDouble(novoValorDiariaStr);
            veiculoAtual.setValorDiaria(novoValorDiaria);
        }
        System.out.println("Veiculo alterado com sucesso!");
    }
    
    /**
     * 
     */
    public void exibirMenuRemocao() {
        System.out.println("=== REMOCAO DE VEICULO ===");
        System.out.print("Placa do veiculo a ser removido: ");
        String placa = scanner.nextLine();
        boolean sucesso = locadora.remove(placa);
        if (sucesso) {
            System.out.println("Veiculo removido com sucesso!");
        } else {
            System.out.println("Veiculo nao encontrado!");
        }
    }
    
    /**
     * 
     */
    public void exibirRelatorio() {
        System.out.println("=== RELATORIO DE VEICULOS ===");
        System.out.println(locadora.getInfo());
    }
}
