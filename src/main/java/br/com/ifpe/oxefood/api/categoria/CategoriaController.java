package br.com.ifpe.oxefood.api.categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ifpe.oxefood.modelo.categoria.Categoria;
import br.com.ifpe.oxefood.modelo.categoria.CategoriaService;
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

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin
public class CategoriaController {
     @Autowired
   private CategoriaService categoriaService;

   @PostMapping
   public ResponseEntity<Categoria> save(@RequestBody CategoriaRequest request) {

       Categoria categoria = categoriaService.save(request.build());
       return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
   }
   @GetMapping
//  duas novas rotas para cliente
    public List<Categoria> listarTodos() {
        return categoriaService.listarTodos();
    }
    @GetMapping("/{id}")
    public Categoria obterPorID(@PathVariable Long id) {
        return categoriaService.obterPorID(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable("id") Long id, @RequestBody CategoriaRequest request) {

       categoriaService.update(id, request.build());
       return ResponseEntity.ok().build();
 }
      @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

    categoriaService.delete(id);
       return ResponseEntity.ok().build();
   }
}
