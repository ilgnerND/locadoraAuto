import excecoes.clienteexcecao.ClienteExistenteException;
import excecoes.clienteexcecao.ClienteNaoEncontradoException;
import consoles.LocadoraVeiculosConsole;
import excecoes.veiculosececao.ColecaoVaziaException;
import excecoes.veiculosececao.VeiculoExistenteException;
import excecoes.veiculosececao.VeiculoNaoEncontradoException;

public class Main {
    public static void main(String[] args) throws ClienteNaoEncontradoException, VeiculoNaoEncontradoException, ClienteExistenteException, VeiculoExistenteException, ColecaoVaziaException {
        LocadoraVeiculosConsole interfaceConsole = new LocadoraVeiculosConsole();
        interfaceConsole.exibirMenuLocadoraVeic();
    }
}
