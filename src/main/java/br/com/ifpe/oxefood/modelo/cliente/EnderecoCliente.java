package br.com.ifpe.oxefood.modelo.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import java.util.List;
import org.hibernate.annotations.SQLRestriction;
// lombok 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// --------------------------------------JPA----------------------------------------------- 
// torna a classe manipulavel pelo jpa
@Entity
// iNdica que a classe vira uma tabela no banco / como padrão cria como o nome da classe
@Table(name = "EnderecoCliente")
// acrecenta a uma clausa ware na tabela cliente, para filtrar em  esta habilitado 
@SQLRestriction("habilitado = true")
// ----------------------------------------LOMBOK-------------------------------------------
@Builder
// gerar o gets sets
@Getter
@Setter
// contrutor com paramentro
@AllArgsConstructor
// contrutor fazio
@NoArgsConstructor

    public class EnderecoCliente extends EntidadeAuditavel {
  


   @JsonIgnore
   @ManyToOne
   private Cliente cliente;

   @Column
   private String rua;

   @Column
   private String numero;

   @Column
   private String bairro;
   @Column
   private String cep;

   @Column
   private String cidade;

   @Column
   private String estado;

   @Column
   private String complemento;

}
