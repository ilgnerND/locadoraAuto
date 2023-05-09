import java.util.ArrayList;
import java.util.List;

public class GerenciadorClientes implements IClientes {
    private List<Cliente> clientes;

    public GerenciadorClientes() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void add(Cliente c) {
        clientes.add(c);
    }

    @Override
    public Cliente get(long CPF) {
        for (Cliente c : clientes) {
            if (c.getCpf() == CPF) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String getInfo(long CPF) {
        Cliente c = get(CPF);
        return (c == null) ? null : c.toString();
    }

    @Override
    public String getInfo() {
        if (clientes.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Cliente c : clientes) {
            sb.append(c.toString()).append("\n\n");
        }
        return sb.toString();
    }

    @Override
    public String getResumoInfo() {
        if (clientes.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Cliente c : clientes) {
            sb.append("CPF: ").append(c.getCpf()).append(" - Nome: ").append(c.getNome()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean set(long CPF, Cliente c) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf() == CPF) {
                clientes.set(i, c);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(long CPF) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf() == CPF) {
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existe(long CPF) {
        for (Cliente c : clientes) {
            if (c.getCpf() == CPF) {
                return true;
            }
        }
        return false;
    }
}    
