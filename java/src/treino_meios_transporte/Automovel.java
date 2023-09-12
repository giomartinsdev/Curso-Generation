package treino_meios_transporte;

public class Automovel extends Terrestre{

    private  String cor;
    private  String placa;
    private  Integer qtdPortas;

    public Automovel(int capacidade, int qtdRodas, float velocidade, String cor, String placa, Integer qtdPortas) {
        super(capacidade, qtdRodas, velocidade);
        this.cor = cor;
        this.placa = placa;
        this.qtdPortas = qtdPortas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getqtdPortas() {
        return qtdPortas;
    }

    public void setqtdPortas(Integer qtdPortas) {
        this.qtdPortas = qtdPortas;
    }


    @Override
    public void visualizar(){
        super.visualizar();
        System.out.println("Cor: " + this.cor);
        System.out.println("Numero de Porta: " + this.qtdPortas);
        System.out.println("Numero da placa: " + this.placa);
    }
}
