package desafioobjetos.desafio1;
public class PessoaFisica extends DadosClientes {

    private String cpfCliente;

    public PessoaFisica(String nome, int idade, float altura, char sexo, float peso, String cpfCliente) {
        super(nome, idade, altura, sexo, peso);
        this.cpfCliente = cpfCliente;
    }

    public void modeloCPF(){
            if( getIdade() > 50) {
                System.out.println("\nO cliente tem um cpf no modelo antigo!");
            }else System.out.println("\nO cliente tem um cpf no modelo novo!");
    }

    @Override
    public void inputCliente(){
        super.inputCliente();
        System.out.println("Digite o CPF do cliente: ");
        setCpfCliente(leia.nextLine());
    }
    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("\nO cpf do cliente é: " + this.cpfCliente);

    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
}
