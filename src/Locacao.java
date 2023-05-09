
import java.time.LocalDate;

public class Locacao {
    
    private int codigo;
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    public Locacao(int codigo, Cliente cliente, Veiculo veiculo, LocalDate dataInicial, LocalDate dataFinal) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    @Override
    public String toString() {
        return "Locação [Código: " + codigo + ", Cliente: " + cliente.getNome() + ", Veículo: " + veiculo.getPlaca()
                + ", Data Inicial: " + dataInicial + ", Data Final: " + dataFinal + "]";
    }
}
