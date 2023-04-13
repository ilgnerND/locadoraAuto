// Classe Onibus que herda de Veiculo
class Onibus extends Veiculo {
    private int numeroPassageiros;
    private String categoria;

    // Construtor
    public Onibus(String placa, int ano, double valorDiaria, boolean locado, int numeroPassageiros, String categoria) {
        super(placa, ano, valorDiaria, locado);
        this.numeroPassageiros = numeroPassageiros;
        this.categoria = categoria;
    }

    public int getNumeroPassageiros() {
        return numeroPassageiros;
    }

    public void setNumeroPassageiros(int numeroPassageiros) {
        this.numeroPassageiros = numeroPassageiros;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Onibus [numeroPassageiros=" + numeroPassageiros + ", categoria=" + categoria + "]";
    }

    

}