package com.github.hugovallada.algafoodapi.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_forma_pagamento")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String descricao;
}
