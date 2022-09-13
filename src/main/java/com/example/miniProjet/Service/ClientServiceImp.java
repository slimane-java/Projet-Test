package com.example.miniProjet.Service;

import com.example.miniProjet.dao.ClientRepository;
import com.example.miniProjet.Entity.ClientEntity;
import com.example.miniProjet.dto.ClientFullNameDto;
import com.example.miniProjet.dto.ClientGetDto;
import com.example.miniProjet.dto.ClientPostDto;
import com.example.miniProjet.exception.AlreadyExists;
import com.example.miniProjet.exception.ResourceNotFoundException;
import com.example.miniProjet.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final PasswordEncoder passwordEncoder;

    
    @Override
    public ClientGetDto add(ClientPostDto clientPostDto) {
        Optional<ClientEntity> client = clientRepository.findByUsername(clientPostDto.getEmailClient());

        if(client.isPresent()) {
            throw  new AlreadyExists("this Client is already Exists");
        } else {
            ClientEntity clientAdd = clientMapper.clientPostDtoToClientEntity(clientPostDto);
            clientAdd.setPassword(passwordEncoder.encode(clientPostDto.getPasswordClient()));
            return clientMapper.clientEntityToClientGetDto(clientRepository.save(clientAdd));
        }

    }

    @Override
    public ClientGetDto getById(Long id) {
        return clientMapper.clientEntityToClientGetDto(clientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Client not Found")));
    }

    @Override
    public List<ClientGetDto> getAll() {
        return clientMapper.getAll(clientRepository.findAll());
    }

	@Override
	public ClientGetDto update(ClientPostDto clientPostDto) {
		// TODO Auto-generated method stub
        ClientEntity client =  clientMapper.clientPostDtoToClientEntity(clientPostDto);

        return clientMapper.clientEntityToClientGetDto(clientRepository.save(client));
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clientRepository.delete(clientRepository.getById(id));
	}

	@Override
    @Transactional
    public void updateFullname(ClientFullNameDto clientFullNameDto) {
		// TODO Auto-generated method stub
		clientRepository.updateFirstNameAndLastName(clientFullNameDto.getFirstName(), clientFullNameDto.getLastName(), clientFullNameDto.getId());
	}
}
