class Carro extends Veiculo {
    private double mediaKmPorLitro;
    private boolean arCondicionado;

    // Construtor
    public Carro(String placa, int ano, double valorDiaria, boolean locado, double mediaKmPorLitro, boolean arCondicionado) {
        super(placa, ano, valorDiaria, locado);
        this.mediaKmPorLitro = mediaKmPorLitro;
        this.arCondicionado = arCondicionado;
    }

    public double getMediaKmPorLitro() {
        return mediaKmPorLitro;
    }

    public void setMediaKmPorLitro(double mediaKmPorLitro) {
        this.mediaKmPorLitro = mediaKmPorLitro;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public String toString() {
        return "Carro [mediaKmPorLitro=" + mediaKmPorLitro + ", arCondicionado=" + arCondicionado + "]";
    }

    
}
