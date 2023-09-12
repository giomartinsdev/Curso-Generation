package desafioobjetos.desafio2;

public class Gerente extends Funcionario {
    //------------------------------------------------------------------------------------------------------------
    //-------------------------------------------- ATRIBUTOS -----------------------------------------------------
    private Integer idDeGerente;

    //------------------------------------------------------------------------------------------------------------
    //-------------------------------------------- CONSTRUTOR ----------------------------------------------------
    public Gerente(String nome, String sobrenome, Integer telefone, String cargo, Double salario, Integer idDeGerente) {
        super(nome, sobrenome, telefone, cargo, salario);
        this.idDeGerente = idDeGerente;
    }

    //------------------------------------------------------------------------------------------------------------
    //---------------------------------------METODOS SETTERS E GETTERS -------------------------------------------
    public Integer getIdDeGerente() {
        return idDeGerente;
    }
    public void setIdDeGerente(Integer idDeGerente) {
        this.idDeGerente = idDeGerente;
    }

    //------------------------------------------------------------------------------------------------------------
    //----------------------------------------- VISUALIZADOR -----------------------------------------------------

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Id de Gerente: "+getIdDeGerente());
        System.out.println("--------------------------");
        System.out.print("\n");
    }
}
