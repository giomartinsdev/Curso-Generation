package desafioobjetos.desafio1;

public class Cliente {

    //------------------------------------------------------------------------------------------------------------
    //-------------------------------------------- ATRIBUTOS -----------------------------------------------------

    private String nome;
    private String sobrenome;
    private Integer telefone;
    private String email;
    private String localidade;


    //------------------------------------------------------------------------------------------------------------
    //---------------------------------------METODOS SETTERS E GETTERS --------------------------------------------------

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLocalidade() {
        return localidade;
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    //------------------------------------------------------------------------------------------------------------
    //---------------------------------------METODOS FUNCIONAIS --------------------------------------------------

    public Cliente(String nome, String sobrenome, Integer telefone, String email, String localidade) {
        setNome(nome);
        setSobrenome(sobrenome);
        setTelefone(telefone);
        setEmail(email);
        setLocalidade(localidade);
    }

    public void visualizar(){
        System.out.println("Nome do cliente: "+getNome());
        System.out.println("Sobrenome do cliente: "+getSobrenome());
        System.out.println("Telefone do cliente: (21)"+getTelefone());
        System.out.println("Email do cliente: "+getEmail());
        System.out.println("Localidade do cliente: "+getLocalidade());
        System.out.println("\n");
    }
}