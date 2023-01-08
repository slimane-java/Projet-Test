package com.example.miniProjet.dto;

import com.example.miniProjet.customAnnotation.PasswordValidator;
import com.example.miniProjet.enums.RolesEnum;
import com.example.miniProjet.validateInterface.OnCreateClient;
import com.example.miniProjet.validateInterface.OnCreateOrder;
import com.example.miniProjet.validateInterface.OnUpdateClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PasswordValidator
public class

ClientPostDto {

    @Null(groups = OnCreateClient.class)
    @NotNull(groups = {OnUpdateClient.class, OnCreateOrder.class})
    private  Long idClient;
    @NotBlank(message = "sorry should the name not null")
    private String username;
    @NotBlank
    private String firstNameClient;
    @NotBlank
    private String lastNameClient;
    @Min(value = 18, message = "age shoud be above 18")
    @Max(value = 80, message = "age should be under 80" )
    private int ageClient;
    @Email
    private String emailClient;
    @NotBlank
    private String passwordClient;
    @NotBlank
    private String passwordConfermClient;
    private List<RolesEnum> rolesEntities;
}
