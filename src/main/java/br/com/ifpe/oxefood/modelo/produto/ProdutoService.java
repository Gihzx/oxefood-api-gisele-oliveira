package br.com.ifpe.oxefood.modelo.produto;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService  {
         @Autowired
   private ProdutoRepository repository;
    // Abrir um ploco de trnasação
         @Transactional
   public Produto save(Produto produto) {
    produto.setHabilitado(Boolean.TRUE);
       return repository.save(produto);
   }
      public List<Produto> listarTodos() {
  
    return repository.findAll();         //selec * from cliente
}

public Produto obterPorID(Long id) {

    return repository.findById(id).get();  //select * from cliente where id = ? 
}
@Transactional
public void update(Long id, Produto produtoAlterado) {

   Produto produto = repository.findById(id).get();
   produto.setCodigo(produtoAlterado.getCodigo());
   produto.setTitulo(produtoAlterado.getTitulo());
   produto.setDescricao(produtoAlterado.getDescricao());
   produto.setValorUnitario(produtoAlterado.getValorUnitario());
   produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
   produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());
   repository.save(produto);
}

}
