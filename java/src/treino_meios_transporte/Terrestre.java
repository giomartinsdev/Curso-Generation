package treino_meios_transporte;

public class Terrestre extends Transporte {
    private int qtdRodas;
    protected float velocidade;

    public Terrestre(int capacidade, int qtdRodas, float velocidade) {
        super(capacidade);
        this.qtdRodas = qtdRodas;
        this.velocidade = velocidade;
    }

    public int getQtdRodas() {
        return qtdRodas;
    }

    public void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public void visualizar(){
        super.visualizar();
        System.out.println("Numero de rodas: " + this.qtdRodas);
        System.out.println("Velocidade: " + this.velocidade);
    }
}
