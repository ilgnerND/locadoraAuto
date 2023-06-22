import clienteexcecao.ClienteExistenteException;
import clienteexcecao.ClienteNaoEncontradoException;
import veiculosececao.ColecaoVaziaException;
import veiculosececao.VeiculoExistenteException;
import veiculosececao.VeiculoNaoEncontradoException;

public class Main {
    public static void main(String[] args) throws ClienteNaoEncontradoException, VeiculoNaoEncontradoException, ClienteExistenteException, VeiculoExistenteException, ColecaoVaziaException {
        LocadoraVeiculosConsole interfaceConsole = new LocadoraVeiculosConsole();
        interfaceConsole.exibirMenuLocadoraVeic();
    }
}
