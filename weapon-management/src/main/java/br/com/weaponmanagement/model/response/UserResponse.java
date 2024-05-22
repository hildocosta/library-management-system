package br.com.weaponmanagement.model.response;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {


    private Long id;


    private String name;


    private String email;
}
