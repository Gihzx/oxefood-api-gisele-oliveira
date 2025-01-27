package br.com.ifpe.oxefood.api.produto;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import br.com.ifpe.oxefood.modelo.categoria.CategoriaService;
import br.com.ifpe.oxefood.modelo.produto.Produto;
import br.com.ifpe.oxefood.modelo.produto.ProdutoService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin

@Tag(
    name = "API Cliente",
    description = "API responsável pelos servidos de cliente no sistema"
)
public class ProdutoController {
    @Autowired
   private ProdutoService produtoService;


   @Autowired
  private CategoriaService categoriaService;
  @Operation(
    summary = "Serviço responsável por salvar um cliente no sistema.",
    description = "Exemplo de descrição de um endpoint responsável por inserir um cliente no sistema."
)

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
    @PostMapping("/filtrar")
    public List<Produto> filtrar(
           @RequestParam(value = "codigo", required = false) String codigo,
           @RequestParam(value = "titulo", required = false) String titulo,
           @RequestParam(value = "idCategoria", required = false) Long idCategoria) {

       return produtoService.filtrar(codigo, titulo, idCategoria);
   }


}
