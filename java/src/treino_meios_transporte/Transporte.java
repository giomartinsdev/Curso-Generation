package treino_meios_transporte;

public class Transporte {
    private int capacidade;

    public Transporte(int capacidade) {
        this.capacidade = capacidade;
    }


    public int getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public  void visualizar(){
        System.out.println("********************************************************");
        System.out.println("Dados do Meio de Transporte.");
        System.out.println("********************************************************");
        System.out.println("Capacidade numero de passageiros: " + this.capacidade);
    }

}
