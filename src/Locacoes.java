
import java.util.ArrayList;

import model.Locacao;
/**
 * A classe Locacoes representa uma coleção de locações.
 */
public class Locacoes implements ILocacoes {

    private ArrayList<Locacao> listaLocacoes;

    /**
     * Cria uma instância de Locacoes.
     */
    public Locacoes() {
        listaLocacoes = new ArrayList<>();
    }

    /**
     * Adiciona uma locação à coleção de locações.
     *
     * @param l A locação a ser adicionada.
     */
    @Override
    public void add(Locacao l) {
        listaLocacoes.add(l);
    }

    /**
     * Obtém uma locação com base no código fornecido.
     *
     * @param codigo O código da locação a ser obtida.
     * @return A locação com o código correspondente, ou null se não for encontrada.
     */
    @Override
    public Locacao get(int codigo) {
        for (Locacao l : listaLocacoes) {
            if (l.getCodigo() == codigo) {
                return l;
            }
        }
        return null;
    }

    /**
     * Obtém as informações de uma locação com base no código fornecido.
     *
     * @param codigo O código da locação.
     * @return Uma representação em string das informações da locação, ou null se a locação não for encontrada.
     */
    @Override
    public String getInfo(int codigo) {
        for (Locacao l : listaLocacoes) {
            if (l.getCodigo() == codigo) {
                return l.toString();
            }
        }
        return null;
    }

    /**
     * Obtém as informações de todas as locações na coleção.
     *
     * @return Uma representação em string das informações de todas as locações na coleção, ou null se a coleção estiver vazia.
     */
    @Override
    public String getInfo() {
        if (listaLocacoes.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Locacao l : listaLocacoes) {
            sb.append(l.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Substitui uma locação existente com base no código fornecido.
     *
     * @param codigo O código da locação a ser substituída.
     * @param l      A locação a ser inserida.
     * @return true se a locação foi substituída com sucesso, false caso contrário.
     */
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

    /**
     * Remove uma locação com base no código fornecido.
     *
     * @param codigo O código da locação a ser removida.
     * @return true se a locação foi removida com sucesso, false caso contrário.
     */
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

	/**
     * Verifica se uma locação com o código fornecido existe na coleção
	 *
	* @param codigo O código da locação a ser verificada.
	* @return true se a locação existe na coleção, false caso contrário.
	*/
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