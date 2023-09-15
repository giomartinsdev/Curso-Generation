package desafioobjetos.desafio1;
public class PessoaJuridica extends DadosClientes {
    //ATRIBUTOS
    private String cnpjCliente;
    //CONSTRUCTOR
    public PessoaJuridica(String nome, int idade, float altura, char sexo, float peso, String cnpjCliente) {
        super(nome, idade, altura, sexo, peso);
        this.cnpjCliente = cnpjCliente;
    }

    //MÉTODOS
    @Override
    public void inputCliente() {
        super.inputCliente();
        System.out.println("Digite o CNPJ do cliente: ");
        setCnpjCliente(leia.nextLine());
    }
    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("\nO CNPJ do cliente é: " + this.cnpjCliente);

    }

    //GET AND SET
    public String getCnpjCliente() {
        return cnpjCliente;
    }

    public void setCnpjCliente(String cnpjCliente) {
        this.cnpjCliente = cnpjCliente;
    }
}
