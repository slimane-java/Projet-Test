package com.example.miniProjet.dao;

import com.example.miniProjet.Entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
	@Modifying
	@Query("update ClientEntity c set c.firstName = :firstName, c.lastName = :lastName where c.id = :id")
	void updateFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("id") Long id);
	Optional<ClientEntity> findByUsername(String username);

	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
