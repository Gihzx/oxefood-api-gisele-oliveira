package br.com.ifpe.oxefood.api.cliente;
import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;  
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
    // verifica se o campo não é nullo
      @NotNull(message = "O Nome é de preenchimento obrigatório")
      // verifica se o campo não é vazio
   @NotEmpty(message = "O Nome é de preenchimento obrigatório")
   // tamanho maximo do tamanho do caractere
   @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")


   private String nome;
    // formata fomato de data 
   @JsonFormat(pattern = "dd/MM/yyyy")

   private LocalDate dataNascimento;

   //faz duas coisas verifica se é nullo ou vazio 
   @NotBlank(message = "O CPF é de preenchimento obrigatório")
   @CPF
   private String cpf;

   @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
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
