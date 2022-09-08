package com.example.miniProjet.dto;

import com.example.miniProjet.enums.RolesEnum;
import com.example.miniProjet.validateInterface.OnCreateOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientGetDto {

    @NotNull(groups = OnCreateOrder.class)
    private Long id;
	private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String username;
    private List<RolesEnum> rolesEntities;

}
