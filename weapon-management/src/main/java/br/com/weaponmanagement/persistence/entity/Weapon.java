package br.com.weaponmanagement.persistence.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.function.Function;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_weapon")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "patrimonio", nullable = false)
    private String patrimonio;

    public <R> R map(Function<Weapon, R> func){
        return func.apply(this);
    }


}
