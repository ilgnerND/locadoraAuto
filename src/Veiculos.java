
import java.util.ArrayList;
import java.util.List;

import model.Veiculo;

/**
 * A classe Veiculos representa uma coleção de veículos.
 */
public class Veiculos implements IVeiculos {

    private List<Veiculo> veiculos;

    /**
     * Cria uma instância de Veiculos.
     */
    public Veiculos() {
        veiculos = new ArrayList<>();
    }

    /**
     * Adiciona um veículo à coleção de veículos.
     *
     * @param v O veículo a ser adicionado.
     */
    @Override
    public void add(Veiculo v) {
        veiculos.add(v);
    }

    /**
     * Obtém um veículo com base na placa fornecida.
     *
     * @param placa A placa do veículo a ser obtido.
     * @return O veículo com a placa correspondente, ou null se não for encontrado.
     */
    @Override
    public Veiculo get(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Obtém as informações de um veículo com base na placa fornecida.
     *
     * @param placa A placa do veículo.
     * @return Uma representação em string das informações do veículo, ou null se o veículo não for encontrado.
     */
    @Override
    public String getInfo(String placa) {
        Veiculo v = get(placa);
        if (v != null) {
            return v.toString();
        }
        return null;
    }

    /**
     * Obtém as informações de todos os veículos na coleção.
     *
     * @return Uma representação em string das informações de todos os veículos na coleção, ou null se a coleção estiver vazia.
     */
    @Override
    public String getInfo() {
        if (veiculos.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Veiculo v : veiculos) {
            sb.append(v.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Obtém um resumo das informações (placa, ano e valor diária) de todos os veículos na coleção.
     *
     * @return Uma representação em string do resumo das informações de todos os veículos na coleção, ou null se a coleção estiver vazia.
     */
    @Override
    public String getResumoInfo() {
        if (veiculos.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Veiculo v : veiculos) {
            sb.append(v.getPlaca());
            sb.append(", ");
            sb.append(v.getAno());
            sb.append(", ");
            sb.append(v.getValorDiaria());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Substitui um veículo existente com base na placa fornecida.
     *
     * @param placa A placa do veículo a ser substituído.
     * @param v     O veículo a ser inserido.
     * @return true se o veículo foi substituído com sucesso, false caso contrário.
     */
    @Override
    public boolean set(String placa, Veiculo v) {
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo current = veiculos.get(i);
            if (current.getPlaca().equals(placa)) {
                veiculos.set(i, v);
                return true;
            }
        }
        return false;
    }
/**
 * Remove um veículo com base na placa fornecida.
 *
 * @param placa A placa do veículo a ser removido.
 * @return true se o veículo foi removido com sucesso, false caso contrário.
 */
@Override
public boolean remove(String placa) {
    for (int i = 0; i < veiculos.size(); i++) {
        Veiculo current = veiculos.get(i);
        if (current.getPlaca().equals(placa)) {
            veiculos.remove(i);
            return true;
        }
    }
    return false;
}

/**
 * Verifica se um veículo com a placa fornecida existe na coleção.
 *
 * @param placa A placa do veículo a ser verificado.
 * @return true se o veículo existe na coleção, false caso contrário.
 */
    @Override
    public boolean existe(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(placa)) {
                return true;
            }
        }
        return false;
    }
}
