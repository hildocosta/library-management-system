package br.com.weaponmanagement.model.response;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovementResponse {

    private Long id;

    private Long weaponId;

    private Long userId;

    private String action;

    private LocalDate date;
}
