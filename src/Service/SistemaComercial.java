package Service;

import Models.Cliente;
import Models.ClientePF;
import Models.ClientePJ;
import Models.Produto;
import Service.Exception.ClienteExisteException;
import Service.Exception.ClienteNãoExisteException;
import Service.Exception.ProdutoExisteException;
import Service.Exception.ProdutoNãoExisteException;
import enums.CategoriaProduto;

import java.util.List;

public interface SistemaComercial   {

    boolean existeProduto(String codigoProduto);

    void cadastrarProduto(Produto produto) throws ProdutoExisteException;

    Produto pesquisarProdutoPeloCodigo(String codigoProduto) throws ProdutoNãoExisteException;

    List<Produto> pesquisarProdutoPelaCategoria(CategoriaProduto categoria);

    void removerProdutoPeloCodigo(String codigoProduto) throws ProdutoNãoExisteException;

    boolean existeCliente(String email);

    void cadastrarCliente(ClientePF cliente) throws ClienteExisteException;

    void cadastrarCliente(ClientePJ cliente);

    List<Cliente> pesquisarClientesPeloNome(String nome) throws ClienteExisteException;

    void removerCliente(String email) throws ClienteNãoExisteException;
}
