import java.util.ArrayList;

public class Locacoes implements ILocacoes {
    
    private ArrayList<Locacao> listaLocacoes;
    
    public Locacoes() {
        listaLocacoes = new ArrayList<>();
    }
    
    @Override
    public void add(Locacao l) {
        listaLocacoes.add(l);
    }

    @Override
    public Locacao get(int codigo) {
        for (Locacao l : listaLocacoes) {
            if (l.getCodigo() == codigo) {
                return l;
            }
        }
        return null;
    }

    @Override
    public String getInfo(int codigo) {
        for (Locacao l : listaLocacoes) {
            if (l.getCodigo() == codigo) {
                return l.toString();
            }
        }
        return null;
    }

    @Override
    public String getInfo() {
        if (listaLocacoes.isEmpty()) {
            return null;
        }
        String info = "";
        for (Locacao l : listaLocacoes) {
            info += l.toString() + "\n";
        }
        return info;
    }

    @Override
    public boolean set(int codigo, Locacao l) {
        for (int i = 0; i < listaLocacoes.size(); i++) {
            if (listaLocacoes.get(i).getCodigo() == codigo) {
                listaLocacoes.set(i, l);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int codigo) {
        for (Locacao l : listaLocacoes) {
            if (l.getCodigo() == codigo) {
                listaLocacoes.remove(l);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existe(int codigo) {
        for (Locacao l : listaLocacoes) {
            if (l.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }
}