package br.com.supera.game.store.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.store.entities.Client;
import br.com.supera.game.store.services.ClientService;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Client obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

