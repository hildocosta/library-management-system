package br.com.weaponmanagement.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementRequest {

    @NotBlank
    private Long weaponId;

    @NotBlank
    private Long userId;

    @NotBlank
    private String action;

    @NotBlank
    private LocalDate date;
}
