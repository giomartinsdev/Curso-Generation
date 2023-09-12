package desafioobjetos.desafio2;

public class Funcionario {

    //------------------------------------------------------------------------------------------------------------
    //-------------------------------------------- ATRIBUTOS -----------------------------------------------------

    private String nome;
    private String sobrenome;
    private Integer telefone;
    private String cargo;
    private Double salario;


    //------------------------------------------------------------------------------------------------------------
    //-------------------------------------------- CONSTRUTOR ----------------------------------------------------
    public Funcionario(String nome, String sobrenome, Integer telefone, String cargo, Double salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.cargo = cargo;
        this.salario = salario;
    }


    //------------------------------------------------------------------------------------------------------------
    //---------------------------------------METODOS SETTERS E GETTERS -------------------------------------------

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public Integer getTelefone() {
        return telefone;
    }
    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    //------------------------------------------------------------------------------------------------------------
    //----------------------------------------- VISUALIZADOR -----------------------------------------------------

    public void visualizar(){
        System.out.println("--------------------------");
        System.out.println("Nome do funcionario: "+getNome());
        System.out.println("Sobrenome do funcionario: "+getSobrenome());
        System.out.println("Telefone do funcionario: (21)"+getTelefone());
        System.out.println("Cargo do funcionario: "+getCargo());
        System.out.println("Salario do funcionario: "+getSalario());
    }

}