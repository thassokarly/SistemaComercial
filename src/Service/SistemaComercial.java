package Service;

import Models.Cliente;
import Models.ClientePF;
import Models.ClientePJ;
import Models.Produto;
import enums.CategoriaProduto;

import java.util.List;

public interface SistemaComercial   {

    boolean existeProduto(String codigoProduto);

    void cadastrarProduto(Produto produto);

    Produto pesquisarProdutoPeloCodigo(String codigoProduto);

    List<Produto> pesquisarProdutoPelaCategoria(CategoriaProduto categoria);

    void removerProdutoPeloCodigo(String codigoProduto);

    boolean existeCliente(String email);

    void cadastrarCliente(ClientePF cliente);

    void cadastrarCliente(ClientePJ cliente);

    List<Cliente> pesquisarClientesPeloNome(String nome);

    void removerCliente(String email);
}
