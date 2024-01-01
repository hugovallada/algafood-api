package com.github.hugovallada.algafoodapi.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "tx_frete", nullable = false)
    private BigDecimal taxaFrete;

    @ManyToOne // Muitos restaurantes para uma cozinha
    @JoinColumn(name = "cod_cozinha", nullable = false)
    // nome da coluna q sera usada no banco... usa ele ao invés do @Column quando é @ManyToOne
    private Cozinha cozinha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurante that = (Restaurante) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
