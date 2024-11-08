package br.com.ifpe.oxefood.modelo.produto;

import org.hibernate.annotations.SQLRestriction;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
// iNdica que a classe vira uma tabela no banco / como padrão cria como o nome da classe
@Table(name = "Produto")
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
public class Produto extends EntidadeAuditavel {
      @Column
    private String codigo
    ;
 
    @Column
    private String titulo;
 
    @Column
    private String descricao
    ;
 
    @Column
    private Double valorUnitario;
 
    @Column
    private Integer tempoEntregaMinimo;
    @Column
    private Integer tempoEntregaMaximo;

 
}
