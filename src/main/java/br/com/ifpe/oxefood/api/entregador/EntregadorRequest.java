package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {
      private String nome;
    // formata fomato de data 
   @JsonFormat(pattern = "dd/MM/yyyy")
   private String cpf;
   
   private LocalDate dataNascimento;

   private String rg;

   private String foneCelular;

   private String foneFixo;

   private Integer qtEntregasRealizadas;

   private Double valorFrete;

   private String enderecoRua;  

   private String enderecoComplemento;

   private String enderecoNumero;   

   private String enderecoBairro;

   private String enderecoCidade;

   private String enderecoCep;

   private String enderecoUf;

   private Boolean ativo;

 public Entregador build() {

       return Entregador.builder()
           .nome(nome)
           .cpf(cpf)
           .dataNascimento(dataNascimento)
           .rg(rg)
           .foneCelular(foneCelular)
           .foneFixo(foneFixo)
           .qtEntregasRealizadas(qtEntregasRealizadas)
           .valorFrete(valorFrete)
           .enderecoRua(enderecoRua)
           .enderecoComplemento(enderecoComplemento)
           .enderecoNumero(enderecoNumero)
           .enderecoBairro(enderecoBairro)
           .enderecoCidade(enderecoCidade)
           .enderecoCep(enderecoCep)
           .enderecoUf(enderecoUf)
           .ativo(ativo)
           .build();
   }
}

