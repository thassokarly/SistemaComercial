package Models;

public class ClientePF extends Cliente {

    private String cpf;

    public ClientePF(String nome, String endereco, String email, String cpf) {
        super(nome, endereco, email);
        this.cpf = cpf;
    }

    public ClientePF() {
    }

    @Override
    public String toString() {
        return "Nome" + super.getNome() + "Email" + super.getEmail() + "Endereço" + super.getEndereco() + "CPF" + cpf;
    }

}
