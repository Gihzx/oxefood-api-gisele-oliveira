package br.com.ifpe.oxefood.api.produto;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.categoria.CategoriaService;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin

public class ProdutoController {
    @Autowired
   private ProdutoService produtoService;

   @Autowired
  private CategoriaService categoriaService;

   @PostMapping
   public ResponseEntity<Produto> save(@RequestBody ProdutoRequest request) {

      
    Produto produtoNovo = request.build();
    produtoNovo.setCategoria(categoriaService.obterPorID(request.getIdCategoria()));
    Produto produto = produtoService.save(produtoNovo);

       return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
   }
    @GetMapping
//  duas novas rotas para cliente
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto obterPorID(@PathVariable Long id) {
        return produtoService.obterPorID(id);
    }
     @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest request) {

        Produto produto = request.build();
        produto.setCategoria(categoriaService.obterPorID(request.getIdCategoria()));
        produtoService.update(id, produto);
 
       return ResponseEntity.ok().build();
 }
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       produtoService.delete(id);
       return ResponseEntity.ok().build();
   }

}
