import java.util.ArrayList;
import java.util.List;

public class Veiculos implements IVeiculos{
    private List<Veiculo> veiculos;

    public Veiculos() {
        veiculos = new ArrayList<>();
    }

    @Override
    public void add(Veiculo v) {
        veiculos.add(v);
    }

    @Override
    public Veiculo get(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    @Override
    public String getInfo(String placa) {
        Veiculo v = get(placa);
        if (v != null) {
            return v.toString();
        }
        return null;
    }

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
