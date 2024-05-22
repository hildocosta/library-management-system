package br.com.weaponmanagement.model.request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeaponRequest {

    @NotBlank
    private String tipo;

    @NotBlank
    private String patrimonio;
}
