package br.com.ifpe.oxefood.api.cliente;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// LOBOMK
// substitu gat e sets
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

   private String nome;
    // formata fomato de data 
   @JsonFormat(pattern = "dd/MM/yyyy")

   private LocalDate dataNascimento;

   private String cpf;

   private String foneCelular;

   private String foneFixo;

   public Cliente build() {

       return Cliente.builder()
           .nome(nome)
           .dataNascimento(dataNascimento)
           .cpf(cpf)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .build();
   }

}
