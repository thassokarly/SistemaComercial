package Service;

import Models.Cliente;
import Models.ClientePF;
import Models.ClientePJ;
import Models.Produto;
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
    public void cadastrarProduto(Produto produto) {
         mapaDeProdutos.put(produto.getCodigo(), produto);
    }

    @Override
    public Produto pesquisarProdutoPeloCodigo(String codigoProduto) {
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
    public void removerProdutoPeloCodigo(String codigoProduto) {
        mapaDeProdutos.remove(codigoProduto);
    }

    @Override
    public boolean existeCliente(String email) {
        return mapaDeClientes.containsKey(email);
    }

    @Override
    public void cadastrarCliente(ClientePF cliente) {
        mapaDeClientes.put(cliente.getEmail(),cliente);
    }

    @Override
    public void cadastrarCliente(ClientePJ cliente) {
        mapaDeClientes.put(cliente.getEmail(),cliente);
    }

    @Override
    public List<Cliente> pesquisarClientesPeloNome(String nome) {
        List<Cliente> clientesRetornados = new ArrayList<>();

        for (Cliente clien : mapaDeClientes.values()){
            if (clien.getEmail().equalsIgnoreCase(nome)){
                clientesRetornados.add(clien);
            }
        }
        return null;
    }

    @Override
    public void removerCliente(String email) {
        mapaDeClientes.remove(email);
    }
}
