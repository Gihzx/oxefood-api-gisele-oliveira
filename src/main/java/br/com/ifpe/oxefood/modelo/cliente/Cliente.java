package br.com.ifpe.oxefood.modelo.cliente;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    @OneToOne
   @JoinColumn(nullable = false)
   private Usuario usuario;


             @OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER)
                @Fetch(FetchMode.SUBSELECT)

   private List<EnderecoCliente> enderecos;
//   @column faz que que seja criada colunas nas tabelas/ c
    @Column(nullable = false, length = 100)
    private String nome;
 
    @Column
    private LocalDate dataNascimento;
 
    @Column (unique = true)
    private String cpf;
 
    @Column
    private String foneCelular;
 
    @Column
    private String foneFixo;
 

}
