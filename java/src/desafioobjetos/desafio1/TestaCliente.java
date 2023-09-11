package desafioobjetos.desafio1;

public class TestaCliente {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Giovanni","Martins",980957143,"Giovannimartins@gmail.com","Rio de Janeiro");
        Cliente cliente2 = new Cliente("Elisa","wori",980957143,"fhdsagds@gmail.com","Sao Paulo");
        cliente1.visualizar();
        cliente2.visualizar();
    }
}
