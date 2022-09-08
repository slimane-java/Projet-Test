package com.example.miniProjet.mapper;



import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.miniProjet.Entity.ClientEntity;
import com.example.miniProjet.dto.ClientFullNameDto;
import com.example.miniProjet.dto.ClientGetDto;
import com.example.miniProjet.dto.ClientPostDto;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Optional;

@Mapper(
	    componentModel = "spring"
	)
public interface ClientMapper {

    ClientPostDto clientEntityToClientDto(ClientEntity clientEntity);
	@Mapping(target="id", source="idClient")
	@Mapping(target="firstName", source="firstNameClient")
	@Mapping(target="lastName", source="lastNameClient")
	@Mapping(target="age", source="ageClient")
	@Mapping(target="email", source="emailClient")
	@Mapping(target="password", source="passwordClient")
	@Mapping(target="username", source="username")
    ClientEntity clientPostDtoToClientEntity(ClientPostDto clientPostDto);

    List<ClientEntity> clientPostDtoToClientEntities(List<ClientPostDto> clientPostDtos);

    ClientGetDto clientEntityToClientGetDto(ClientEntity clientEntity);

    ClientEntity ClientFullNameDtoToClientEntity(ClientFullNameDto clientFullNameDto);

	void update(ClientFullNameDto clientFullNameDto, @MappingTarget ClientPostDto clientPostDto);

	List<ClientGetDto> getAll(List<ClientEntity> list);
}
