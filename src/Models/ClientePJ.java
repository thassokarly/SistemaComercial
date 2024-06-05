package Models;

public class ClientePJ extends Cliente {

    private String cnpj;

    public ClientePJ(String nome, String endereco, String email, String cnpj) {
        super(nome, endereco, email);
        this.cnpj = cnpj;
    }

    public ClientePJ() {
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return "Nome" + super.getNome() + "Email" + super.getEmail() + "Endereço" + super.getEndereco() + "CNPJ" + cnpj;
    }
}
