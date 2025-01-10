package br.com.ifpe.oxefood.util.entity;
import java.time.LocalDate;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Version;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// ESTARA MAPEADA NO JPA, MAS NÃO gerar UMA TABELA, EXESTE PARA DEFINIR ATRIBUTOS 
@MappedSuperclass
// 
@EntityListeners(AuditingEntityListener.class)

public abstract class EntidadeAuditavel extends EntidadeNegocio {
    // toda vez que consultar o registro, ela não retoran o campo 
   @JsonIgnore
   @Version
   private Long versao;

   @JsonIgnore
   @CreatedDate
   private LocalDate dataCriacao;

   @JsonIgnore
   @LastModifiedDate
   private LocalDate dataUltimaModificacao;

   @CreatedBy
   @ManyToOne
   @JoinColumn
   private Usuario criadoPor; // Id do usuário que o criou

    @CreatedBy
    @ManyToOne
    @JoinColumn
   private Usuario ultimaModificacaoPor; // Id do usuário que fez a última alteração

}
