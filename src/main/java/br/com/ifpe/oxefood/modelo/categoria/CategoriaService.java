package br.com.ifpe.oxefood.modelo.categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class CategoriaService {
          @Autowired
   private CategoriaRepository repository;
    // Abrir um ploco de trnasação
         @Transactional
   public Categoria save(Categoria categoria) {
    categoria.setHabilitado(Boolean.TRUE);
       return repository.save(categoria);
   }
   public List<Categoria> listarTodos() {
  
    return repository.findAll();         //selec * from cliente
}
public Categoria obterPorID(Long id) {

    return repository.findById(id).get();  //select * from cliente where id = ? 
}
@Transactional
public void update(Long id, Categoria categoriaAlterado) {

   Categoria categoria = repository.findById(id).get();
   categoria.setDescricao(categoriaAlterado.getDescricao());
   repository.save(categoria);
}
@Transactional
public void delete(Long id) {

    Categoria categoria = repository.findById(id).get();
    categoria.setHabilitado(Boolean.FALSE);

    repository.save(categoria);
}
}
