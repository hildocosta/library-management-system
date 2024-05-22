package br.com.weaponmanagement.model.response;

import jakarta.persistence.Column;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeaponResponse {

    private Long id;

    private String tipo;

    private String patrimonio;
}
