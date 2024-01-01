package com.github.hugovallada.algafoodapi.domain.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cozinha")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cozinha {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cozinha", nullable = false)
    private String nome;

/**
 @Override public boolean equals(Object o) {
 if (this == o) return true;
 if (o == null || getClass() != o.getClass()) return false;

 Cozinha cozinha = (Cozinha) o;

 return Objects.equals(id, cozinha.id);
 }

 @Override public int hashCode() {
 return id != null ? id.hashCode() : 0;
 }
 */

}
