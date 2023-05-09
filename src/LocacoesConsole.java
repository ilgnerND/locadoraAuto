import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LocacoesConsole {

    private ILocacoes locacoes;

    

    public void exibirMenuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.println("---- Sistema de Locações ----");
            System.out.println("1 - Adicionar locação");
            System.out.println("2 - Ver informações de uma locação");
            System.out.println("3 - Ver informações de todas as locações");
            System.out.println("4 - Modificar uma locação");
            System.out.println("5 - Remover uma locação");
            System.out.println("6 - Sair");
            System.out.print("Digite a opção desejada: ");
            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida, tente novamente.");
                continue;
            }
            switch (opcao) {
                case 1:
                    adicionarLocacao(sc);
                    break;
                case 2:
                    verInfoLocacao(sc);
                    break;
                case 3:
                    verTodasLocacoes();
                    break;
                case 4:
                    modificarLocacao(sc);
                    break;
                case 5:
                    removerLocacao(sc);
                    break;
                case 6:
                    System.out.println("Saindo do sistema de locações...");
                    break;
                default:
                    System.out.println("Opção inválida, tente outra opção");
                    break;
                }
                System.out.println();
            } while (opcao != 6);
        
    }




    
    public void adicionarLocacao(Scanner sc) {
        int codigo;
        do {
            System.out.print("Digite o código da locação: ");
            try {
                codigo = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Código inválido, tente novamente.");
                continue;
            }
            if (locacoes.existe(codigo)) {
                System.out.println("Já existe uma locação com esse código, tente novamente.");
            } else {
                break;
            }
        } while (true);
    
        System.out.print("Digite o nome do cliente: ");
        //String nomeCliente = sc.nextLine();
    
        System.out.print("Digite a placa do veículo: ");
        //String placaVeiculo = sc.nextLine();
    
        LocalDate dataInicial, dataFinal;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            System.out.print("Digite a data inicial (dd/mm/aaaa): ");
            try {
                dataInicial = LocalDate.parse(sc.nextLine(), formatter);
            } catch (Exception e) {
                System.out.println("Data inválida, tente novamente.");
                continue;
            }
            break;
        } while (true);
    
        do {
            System.out.print("Digite a data final (dd/mm/aaaa): ");
            try {
                dataFinal = LocalDate.parse(sc.nextLine(), formatter);
            } catch (Exception e) {
                System.out.println("Data inválida, tente novamente.");
                continue;
            }
            if (dataFinal.isBefore(dataInicial)) {
                System.out.println("A data final deve ser posterior à data inicial, tente novamente.");
                continue;
            }
            break;
        } while (true);
    
        Locacao locacao = new Locacao(codigo, null, null, dataInicial, dataFinal);
        locacoes.add(locacao);
    
        System.out.println("Locação adicionada com sucesso!");
    }
    
    public void verInfoLocacao(Scanner sc) {
        int codigo;
        do {
            System.out.print("Digite o código da locação: ");
            try {
                codigo = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Código inválido, tente novamente.");
                continue;
            }
            if (!locacoes.existe(codigo)) {
                System.out.println("Não existe uma locação com esse código, tente novamente.");
            } else {
                break;
            }
        } while (true);
    
        String info = locacoes.getInfo(codigo);
        System.out.println(info);
    }
    
    public void verTodasLocacoes() {
        String info = locacoes.getInfo();
        if (info == null) {
            System.out.println("Não há locações cadastradas.");
        } else {
            System.out.println(info);
        }
    }
    
    public void modificarLocacao(Scanner sc) {
        int codigo;
        do {
            System.out.print("Digite o código da locação: ");
            try {
                codigo = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Código inválido, tente novamente.");
                continue;
            }
            if (!locacoes.existe(codigo)) {
                System.out.println("Não existe uma locação com esse código, tente novamente.");
            } else {
                break;
            }
        } while (true);
    
        System.out.print("Digite o nome do cliente (ou deixe em branco para não modificar): ");
        String nomeCliente = sc.nextLine();
    
        System.out.print("Digite a placa do veículo (ou deixe em branco para não modificar): ");
        String placaVeículo = sc.nextLine();

        LocalDate dataInicial = null, dataFinal = null;
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

do {
    System.out.print("Digite a data inicial (dd/mm/aaaa) (ou deixe em branco para não modificar): ");
    String dataInicialInput = sc.nextLine().trim();
    if (dataInicialInput.isEmpty()) {
        break;
    }
    try {
        dataInicial = LocalDate.parse(dataInicialInput, formatter);
    } catch (Exception e) {
        System.out.println("Data inválida, tente novamente.");
        continue;
    }
    break;
} while (true);

do {
    System.out.print("Digite a data final (dd/mm/aaaa) (ou deixe em branco para não modificar): ");
    String dataFinalInput = sc.nextLine().trim();
    if (dataFinalInput.isEmpty()) {
        break;
    }
    try {
        dataFinal = LocalDate.parse(dataFinalInput, formatter);
    } catch (Exception e) {
        System.out.println("Data inválida, tente novamente.");
        continue;
    }
    if (dataInicial != null && dataFinal.isBefore(dataInicial)) {
        System.out.println("A data final deve ser posterior à data inicial, tente novamente.");
        continue;
    }
    break;
} while (true);

if (nomeCliente.isEmpty() && placaVeículo.isEmpty() && dataInicial == null && dataFinal == null) {
    System.out.println("Nenhum dado foi modificado.");
} else {
    locacoes.set(codigo, null);
    System.out.println("Locação modificada com sucesso!");
}

}

public void removerLocacao(Scanner sc) {
int codigo;
do {
System.out.print("Digite o código da locação: ");
try {
codigo = Integer.parseInt(sc.nextLine());
} catch (NumberFormatException e) {
System.out.println("Código inválido, tente novamente.");
continue;
}
if (!locacoes.existe(codigo)) {
System.out.println("Não existe uma locação com esse código, tente novamente.");
} else {
break;
}
} while (true);

locacoes.remove(codigo);
System.out.println("Locação removida com sucesso!");

}

}

    


