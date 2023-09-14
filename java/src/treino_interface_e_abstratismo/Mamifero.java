package treino_interface_e_abstratismo;

public abstract class Mamifero implements Animal{
    public Mamifero() {
    }
    public void comer(String comida) {
        System.out.println("Hoje eu comi "+ comida);
    }
    public void defecar() {

    }
    public void dormir() {

    }
}
