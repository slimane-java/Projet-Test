package com.example.miniProjet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientFullNameDto {

	@NotNull
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
}
