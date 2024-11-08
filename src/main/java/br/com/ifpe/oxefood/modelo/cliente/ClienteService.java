package br.com.ifpe.oxefood.modelo.cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;


@Service

public class ClienteService {
  // istacia um o
     @Autowired
   private ClienteRepository repository;
    // Abrir um ploco de trnasação
   @Transactional
   public Cliente save(Cliente cliente) {

       cliente.setHabilitado(Boolean.TRUE);
       return repository.save(cliente);
   }

}
