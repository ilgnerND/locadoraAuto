import java.util.ArrayList;
import java.util.List;

public class Locacoes implements ILocacoes {

    private List<Locacao> locacoes;

    public Locacoes() {
        locacoes = new ArrayList<>();
    }

    @Override
    public void add(Locacao l) {
        locacoes.add(l);
    }

    @Override
    public Locacao get(int codigo) {
        for (Locacao l : locacoes) {
            if (l.getCodigo() == codigo) {
                return l;
            }
        }
        return null;
    }

    @Override
    public String getInfo(int codigo) {
        Locacao l = get(codigo);
        if (l != null) {
            return l.toString();
        }
        return null;
    }

    @Override
    public String getInfo() {
        if (locacoes.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Locacao l : locacoes) {
            sb.append(l.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean set(int codigo, Locacao l) {
        for (int i = 0; i < locacoes.size(); i++) {
            if (locacoes.get(i).getCodigo() == codigo) {
                locacoes.set(i, l);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int codigo) {
        for (Locacao l : locacoes) {
            if (l.getCodigo() == codigo) {
                locacoes.remove(l);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existe(int codigo) {
        for (Locacao l : locacoes) {
            if (l.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }
}

