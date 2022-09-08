package com.example.miniProjet.Api;

import com.example.miniProjet.enums.RolesEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private static final long serialVersionUID = -8091879091924046844L;
    private String jwttoken;
    private Long id;
    private String username;
    private String email;
    private List<String> rolesEnums;


}
