import java.util.Scanner;

public class ConsoleCliente {

    private GerenciadorClientes gerenciador;

    

    public void exibirMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("----- GERENCIADOR DE CLIENTES -----");
            System.out.println("1 - Cadastrar novo cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente por CPF");
            System.out.println("4 - Alterar dados do cliente");
            System.out.println("5 - Remover cliente");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarNovoCliente(scanner);
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    buscarClientePorCPF(scanner);
                    break;
                case 4:
                    alterarDadosDoCliente(scanner);
                    break;
                case 5:
                    removerCliente(scanner);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println();
        } while (opcao != 6);
    }

    private void cadastrarNovoCliente(Scanner scanner) {
        System.out.println("----- CADASTRAR NOVO CLIENTE -----");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        long cpf = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Número da carteira de motorista: ");
        String carteiraMotorista = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf, carteiraMotorista, endereco, telefone);
        gerenciador.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void listarClientes() {
        System.out.println("----- LISTAR CLIENTES -----");
        String info = gerenciador.getInfo();
        if (info == null) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println(info);
        }
    }

    private void buscarClientePorCPF(Scanner scanner) {
        System.out.println("----- BUSCAR CLIENTE POR CPF -----");
        System.out.print("CPF: ");
        long cpf = scanner.nextLong();
        scanner.nextLine();
        Cliente cliente = gerenciador.get(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
        } else {
            System.out.println(cliente);
        }
    }

    private void alterarDadosDoCliente(Scanner scanner) {
        System.out.println("----- ALTERAR DADOS DO CLIENTE -----");
        System.out.print("CPF: ");
        long cpf = scanner.nextLong();
        scanner.nextLine();
        Cliente clienteAntigo = gerenciador.get(cpf);
        if (clienteAntigo == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        System.out.println("Dados do cliente:");
        System.out.println(clienteAntigo);
        System.out.print("Novo nome (ou Enter para manter o mesmo): ");
        String nome = scanner.nextLine();
        if (!nome.isBlank()) {
            clienteAntigo.setNome(nome);
        }
        System.out.print("Novo número da carteira de motorista (ou Enter para manter o mesmo): ");
        String carteiraMotorista = scanner.nextLine();
        if (!carteiraMotorista.isBlank()) {
            clienteAntigo.setNumCarteiraMotorista(carteiraMotorista);
        }
        System.out.print("Novo endereço (ou Enter para manter o mesmo): ");
        String endereco = scanner.nextLine();
        if (!endereco.isBlank()) {
            clienteAntigo.setEndereco(endereco);
        }
        System.out.print("Novo telefone (ou Enter para manter o mesmo): ");
        String telefone = scanner.nextLine();
        if (!telefone.isBlank()) {
            clienteAntigo.setTelefone(telefone);
        }
        System.out.println("Dados do cliente atualizados.");
    }

    private void removerCliente(Scanner scanner) {
        System.out.println("----- REMOVER CLIENTE -----");
        System.out.print("CPF: ");
        long cpf = scanner.nextLong();
        scanner.nextLine();
        boolean removido = gerenciador.remove(cpf);
        if (removido) {
            System.out.println("Cliente removido com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}

       

