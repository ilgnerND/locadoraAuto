
/**
 * Classe base Veiculo.
 * @author Ilgner
 */
abstract class Veiculo {
    protected String placa;
    protected int ano;
    protected double valorDiaria;
    protected boolean locado; // Indica se o veículo está locado ou não


    // Construtor
    /**
     * @param placa
     * @param ano
     * @param valorDiaria
     * @param locado
     */
    public Veiculo(String placa, int ano, double valorDiaria, boolean locado) {
        this.placa = placa;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
        this.locado = locado;

    }

    /**
     * @return
     */
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public boolean isLocado() {
        return locado;
    }

    public void setLocado(boolean locado) {
        this.locado = locado;
    }

    @Override
    public String toString() {
        return "Veiculo [placa= " + placa + ", ano= " + ano + ", valorDiaria= " + valorDiaria + "locado= "+ locado +"]";
    }

    

    
    
}