package br.com.supera.game.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supera.game.store.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
