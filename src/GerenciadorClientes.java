import java.util.ArrayList;
import java.util.List;
/**
 * A classe GerenciadorClientes é responsável por gerenciar uma coleção de clientes.
 */
public class GerenciadorClientes implements IClientes {
    private List<Cliente> clientes;

    /**
     * Cria uma instância de GerenciadorClientes.
     */
    public GerenciadorClientes() {
        this.clientes = new ArrayList<>();
    }

    /**
     * Adiciona um cliente à coleção de clientes.
     *
     * @param c O cliente a ser adicionado.
     */
    @Override
    public void add(Cliente c) {
        clientes.add(c);
    }

    /**
     * Obtém um cliente com base no CPF fornecido.
     *
     * @param CPF O CPF do cliente a ser obtido.
     * @return O cliente com o CPF correspondente, ou null se não for encontrado.
     */
    @Override
    public Cliente get(long CPF) {
        for (Cliente c : clientes) {
            if (c.getCpf() == CPF) {
                return c;
            }
        }
        return null;
    }

    /**
     * Obtém as informações de um cliente com base no CPF fornecido.
     *
     * @param CPF O CPF do cliente.
     * @return Uma representação em string das informações do cliente, ou null se o cliente não for encontrado.
     */
    @Override
    public String getInfo(long CPF) {
        Cliente c = get(CPF);
        return (c == null) ? null : c.toString();
    }

    /**
     * Obtém as informações de todos os clientes na coleção.
     *
     * @return Uma representação em string das informações de todos os clientes na coleção, ou null se a coleção estiver vazia.
     */
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

    /**
     * Obtém um resumo das informações de todos os clientes na coleção.
     *
     * @return Uma representação em string do resumo das informações de todos os clientes na coleção, ou null se a coleção estiver vazia.
     */
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

    /**
     * Substitui um cliente existente com base no CPF fornecido.
     *
     * @param CPF O CPF do cliente a ser substituído.
     * @param c   O cliente a ser inserido.
     * @return true se o cliente foi substituído com sucesso, false caso contrário.
     */
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
/**
     * Remove um cliente com base no CPF fornecido.
     *
     * @param CPF O CPF do cliente a ser removido.
     * @return true se o cliente foi removido com sucesso, false caso contrário.
	*/
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
	/**
	* Verifica se um cliente com o CPF fornecido existe na coleção.
	*
	* @param CPF O CPF do cliente a ser verificado.
	* @return true se o cliente existe na coleção, false caso contrário.
	*/
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
