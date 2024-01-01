package com.github.hugovallada.algafoodapi.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cidade")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(nullable = false, name = "cod_estado")
    private Estado estado;
}
