package com.example.miniProjet.Service;

import com.example.miniProjet.Entity.ClientEntity;
import com.example.miniProjet.dto.ClientFullNameDto;
import com.example.miniProjet.dto.ClientGetDto;
import com.example.miniProjet.dto.ClientPostDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    ClientGetDto add(ClientPostDto clientPostDto);
    ClientGetDto getById(Long id);
    List<ClientGetDto> getAll();
    ClientGetDto update(ClientPostDto clientPostDto);
    void updateFullname(ClientFullNameDto clientFullNameDto);
    void delete(Long id);
}
