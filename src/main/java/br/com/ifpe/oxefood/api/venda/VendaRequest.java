package br.com.ifpe.oxefood.api.venda;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.venda.Venda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendaRequest {
   
    private String cliente;

   
    private String produto;
 
    private String statusVenda;

    private Double valorTotal;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataVenda;

    private Integer observacao;
 
    private Boolean retiradaEmLoja;
    
    public Venda build() {

       return Venda.builder()
           .cliente(cliente)
           .produto(produto)
           .statusVenda(statusVenda)
           .valorTotal(valorTotal)
           .dataVenda(dataVenda)
           .observacao(observacao)
           .retiradaEmLoja(retiradaEmLoja)
           .build();
   }
}
