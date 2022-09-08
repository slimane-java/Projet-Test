package com.example.miniProjet.security;

import com.example.miniProjet.Entity.ClientEntity;
import com.example.miniProjet.dao.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final ClientRepository clientRepository;
    @Override
    public ClientEntity loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.print("loadUserByUsername 1 username" + username + "\n");

        return clientRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("not found"));
    }
}
