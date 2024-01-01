package com.github.hugovallada.algafoodapi.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_permissao")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;
}
