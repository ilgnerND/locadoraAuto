import java.util.ArrayList;

public class Locadora {
    private ArrayList<Veiculo> veiculos; // Altere o tipo de dado para ArrayList<Veiculo>
    private int numVeiculos;

    // Construtor
    public Locadora() {
        veiculos = new ArrayList<Veiculo>(); // Inicialize o ArrayList
        numVeiculos = 0;
    }

    // Métodos para adicionar e listar veículos
    public void adicionarVeiculo(Veiculo veiculo) {
        if (numVeiculos < veiculos.size()) {
            veiculos.add(veiculo); // Utilize o método add() do ArrayList para adicionar um veículo
            numVeiculos++;
            System.out.println("Veículo adicionado: " + veiculo.toString());
        } else {
            System.out.println("Não é possível adicionar mais veículos. Capacidade máxima alcançada.");
        }
    }

    public void listarVeiculos() {
        System.out.println("Veículos disponíveis na locadora:");
        for (Veiculo veiculo : veiculos) { // Utilize um loop foreach para percorrer o ArrayList
            System.out.println(veiculo.toString());
        }
    }

    // Métodos para locar e devolver veículos
    public void locarVeiculo(String placa) {
        for (Veiculo veiculo : veiculos) { // Utilize um loop foreach para percorrer o ArrayList
            if (veiculo.getPlaca().equals(placa)) {
                if (!veiculo.isLocado()) {
                    veiculo.setLocado(true);
                    System.out.println("Veículo com placa " + placa + " foi locado.");
                } else {
                    System.out.println("Veículo com placa " + placa + " já está locado.");
                }
                return;
            }
        }
        System.out.println("Veículo com placa " + placa + " não encontrado na locadora.");
    }

    public void devolverVeiculo(String placa) {
        for (Veiculo veiculo : veiculos) { // Utilize um loop foreach para percorrer o ArrayList
            if (veiculo.getPlaca().equals(placa)) {
                if (veiculo.isLocado()) {
                    veiculo.setLocado(false);
                    System.out.println("Veículo com placa " + placa + " foi devolvido.");
                } else {
                    System.out.println("Veículo com placa " + placa + " não está locado.");
                }
                return;
            }
        }
        System.out.println("Veículo com placa " + placa + " não encontrado na locadora.");
    }
}
