package com.github.hugovallada.algafoodapi.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_estado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
}
