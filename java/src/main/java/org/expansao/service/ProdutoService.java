package org.expansao.service;

import org.expansao.dto.ProdutoDto;
import org.expansao.model.Loja;
import org.expansao.model.Produto;
import org.expansao.repository.LojaRepository;
import org.expansao.repository.ProdutoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProdutoService {

    @Inject
    private ProdutoRepository produtoRepository;

    @Inject
    private LojaRepository lojaRepository;

    public List<ProdutoDto> produtosPorLoja(long idLoja){

        List<Produto> produtosPorLoja = produtoRepository.findByLoja(idLoja);

        return mapProdutoDto(produtosPorLoja);
    }

    public void adicionarProduto(ProdutoDto produto){

        Loja loja = lojaRepository.findById(produto.getIdLoja());
        produtoRepository.persist(new Produto(loja, produto.getMarca(), produto.getModelo(), produto.getDescricao(), produto.getPreco()));

    }

    public void editarProduto(ProdutoDto produto, long id){

        Produto produtoAlterado = produtoRepository.findById(id);
        produtoAlterado.setDescricao(produto.getDescricao());
        produtoAlterado.setPreco(produto.getPreco());
        produtoRepository.persist(produtoAlterado);

    }

    public void deletarProduto(long id) {
        Produto produto = produtoRepository.findById(id);
        produtoRepository.delete(produto);
    }
    private List<ProdutoDto> mapProdutoDto(List<Produto> produtos){

        List<ProdutoDto> produtosDto = new ArrayList<>();

        produtos.forEach(item->{
            ProdutoDto prods = new ProdutoDto(item.getId(), item.getLoja().getId(), item.getMarca(), item.getModelo(), item.getDescricao(), item.getPreco());
            produtosDto.add(prods);
        });

        return produtosDto;
    }
}
