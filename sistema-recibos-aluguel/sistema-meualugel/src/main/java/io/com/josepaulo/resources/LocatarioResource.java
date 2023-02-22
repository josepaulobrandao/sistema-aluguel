package io.com.josepaulo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.com.josepaulo.domain.Locatario;
import io.com.josepaulo.domain.dtos.LocatarioDTO;
import io.com.josepaulo.services.LocatarioService;

@RestController
@RequestMapping(value = "/locatario")
public class LocatarioResource {
	
	@Autowired
	private LocatarioService LocatarioService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LocatarioDTO> findById(@PathVariable Integer id) {
		Locatario obj = this.LocatarioService.findById(id);
		return ResponseEntity.ok().body(new LocatarioDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<LocatarioDTO>> findAll(){
		List<Locatario> list = LocatarioService.findAll();
		List<LocatarioDTO> listDTO = list.stream().map(obj -> new LocatarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<LocatarioDTO> create(@Valid @RequestBody LocatarioDTO objDTO) {
		Locatario newObj = LocatarioService.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id]").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(null).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LocatarioDTO> update(@PathVariable Integer id, @Valid @RequestBody LocatarioDTO objDTO) {
		Locatario obj = LocatarioService.update(id, objDTO);
		return ResponseEntity.ok().body(new LocatarioDTO(obj));
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<LocatarioDTO> delete(@PathVariable Integer id){
		LocatarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
