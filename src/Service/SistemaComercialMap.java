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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaComercialMap implements SistemaComercial{

    private Map<String,Cliente> mapaDeClientes = new HashMap<>();

    private Map<String,Produto  > mapaDeProdutos = new HashMap<>();

    @Override
    public boolean existeProduto(String codigoProduto) {
        return mapaDeProdutos.containsKey(codigoProduto);
    }

    @Override
    public void cadastrarProduto(Produto produto) throws ProdutoExisteException {
        if (existeProduto(produto.getCodigo())){
            throw new ProdutoExisteException("Produto já existente");
        }
         mapaDeProdutos.put(produto.getCodigo(), produto);
    }

    @Override
    public Produto pesquisarProdutoPeloCodigo(String codigoProduto) throws ProdutoNãoExisteException {
        if (!existeProduto(codigoProduto)){
            throw new ProdutoNãoExisteException("Produto não existe");
        }
        return mapaDeProdutos.get(codigoProduto);
    }

    @Override
    public List<Produto> pesquisarProdutoPelaCategoria(CategoriaProduto categoria) {
        List<Produto> produtosRetornados = new ArrayList<>();
        for (Produto produ : mapaDeProdutos.values() ){
            if (produ.getCategoria().equals(categoria)){
                produtosRetornados.add(produ);
            }
        }
        return  null;
    }

    @Override
    public void removerProdutoPeloCodigo(String codigoProduto) throws ProdutoNãoExisteException {
        if (!existeProduto(codigoProduto)){
            throw new ProdutoNãoExisteException("Produto não existe");
        }
        mapaDeProdutos.remove(codigoProduto);
    }

    @Override
    public boolean existeCliente(String email) {
        return mapaDeClientes.containsKey(email);
    }

    @Override
    public void cadastrarCliente(ClientePF cliente) throws ClienteExisteException {
        if (existeCliente(cliente.getEmail())){
            throw new ClienteExisteException("Cliente já cadastrado");
        }
        mapaDeClientes.put(cliente.getEmail(),cliente);
    }

    @Override
    public void cadastrarCliente(ClientePJ cliente) {
        mapaDeClientes.put(cliente.getEmail(),cliente);
    }

    @Override
    public List<Cliente> pesquisarClientesPeloNome(String nome) throws ClienteExisteException {
        List<Cliente> clientesRetornados = new ArrayList<>();

        for (Cliente clien : mapaDeClientes.values()){
            if (clien.getEmail().equalsIgnoreCase(nome)){
                clientesRetornados.add(clien);
            }
        }
        if (clientesRetornados.isEmpty()){
            throw new ClienteExisteException("Cliente não existe");
        }
        return null;
    }

    @Override
    public void removerCliente(String email) throws ClienteNãoExisteException {
        if (existeCliente(email)){
            throw new ClienteNãoExisteException("Cliente não existe");
        }
        mapaDeClientes.remove(email);
    }
}
