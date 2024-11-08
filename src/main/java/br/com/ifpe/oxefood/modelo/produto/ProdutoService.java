package br.com.ifpe.oxefood.modelo.produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoRepository;
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
}
