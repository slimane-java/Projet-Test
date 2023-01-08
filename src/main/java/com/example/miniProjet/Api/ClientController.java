package com.example.miniProjet.Api;

import com.example.miniProjet.Entity.ClientEntity;

import com.example.miniProjet.Service.ClientService;
import com.example.miniProjet.dto.ClientFullNameDto;
import com.example.miniProjet.dto.ClientGetDto;
import com.example.miniProjet.dto.ClientPostDto;
import com.example.miniProjet.dto.ClientPostDto;
import com.example.miniProjet.mapper.ClientMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor


public class ClientController {

    private final ClientService clientService;


    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('CLIENT') or hasRole('ADMIN')")
    public ClientGetDto getById(@PathVariable(value = "id") Long id) {

        return clientService.getById(id);
    }
    
    @PostMapping("/updateFullName")
    public ResponseEntity<String> ClientUpdateFullName(@RequestBody ClientFullNameDto clientFullNameDto) {

    	return  ResponseEntity.ok("Update");
    }
    
    @DeleteMapping("/delete/{id}")
    public void ClientDelete(@PathVariable(value = "id") Long id) {
    	clientService.delete(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClientGetDto>> getAllClient() {

        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }
    
}
