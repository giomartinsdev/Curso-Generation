package desafioobjetos.desafio2;

public class Vendedor extends Funcionario {
    //------------------------------------------------------------------------------------------------------------
    //-------------------------------------------- ATRIBUTOS -----------------------------------------------------
    private Integer idDeFuncionario;

    //------------------------------------------------------------------------------------------------------------
    //-------------------------------------------- CONSTRUTOR ----------------------------------------------------
    public Vendedor(String nome, String sobrenome, Integer telefone, String cargo, Double salario, Integer idDeFuncionario) {
        super(nome, sobrenome, telefone, cargo, salario);
        this.idDeFuncionario = idDeFuncionario;
    }

    //------------------------------------------------------------------------------------------------------------
    //---------------------------------------METODOS SETTERS E GETTERS -------------------------------------------
    public Integer getIdDeFuncionario() {
        return idDeFuncionario;
    }
    public void setIdDeFuncionario(Integer idDeFuncionario) {
        this.idDeFuncionario = idDeFuncionario;
    }

    //------------------------------------------------------------------------------------------------------------
    //----------------------------------------- VISUALIZADOR -----------------------------------------------------
    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Id de funcionario: "+ getIdDeFuncionario());
        System.out.println("--------------------------");
        System.out.print("\n");
    }
}
