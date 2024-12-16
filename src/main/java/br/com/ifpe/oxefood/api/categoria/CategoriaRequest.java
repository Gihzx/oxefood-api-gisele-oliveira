package br.com.ifpe.oxefood.api.categoria;
import br.com.ifpe.oxefood.modelo.categoria.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequest {
    
      private String descricao;
    // formata fomato de data 

   public Categoria build() {

       return Categoria.builder()
           .descricao(descricao)
           .build();
   }
}
