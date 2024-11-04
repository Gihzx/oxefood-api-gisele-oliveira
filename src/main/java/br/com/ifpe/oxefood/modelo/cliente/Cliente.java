package br.com.ifpe.oxefood.modelo.cliente;

import java.time.LocalDate;
import org.hibernate.annotations.SQLRestriction;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

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
@Table(name = "Cliente")
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
public class Cliente extends EntidadeAuditavel  {
//   @column faz que que seja criada colunas nas tabelas/ c
    @Column
    private String nome;
 
    @Column
    private LocalDate dataNascimento;
 
    @Column
    private String cpf;
 
    @Column
    private String foneCelular;
 
    @Column
    private String foneFixo;
 

}
