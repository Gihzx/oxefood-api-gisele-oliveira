package br.com.ifpe.oxefood.modelo.categoria;
import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
public class Categoria extends EntidadeAuditavel {
         @Column
    private String descricao
    ;
 
}
