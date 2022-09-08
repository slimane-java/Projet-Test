package com.example.miniProjet.dto.RoleDto;

import com.example.miniProjet.enums.RolesEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private Long id;
    private RolesEnum name;
}
