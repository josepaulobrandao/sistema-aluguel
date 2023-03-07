package io.com.josepaulo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.com.josepaulo.domain.Pessoa;
import io.com.josepaulo.domain.Locatario;
import io.com.josepaulo.domain.dtos.LocatarioDTO;
import io.com.josepaulo.repositories.PessoaRepository;
import io.com.josepaulo.repositories.LocatarioRepository;
import io.com.josepaulo.services.exceptions.DataIntegrityViolationException;
import io.com.josepaulo.services.exceptions.ObjectnotFoundException;

@Service
public class LocatarioService {

	@Autowired 
	private LocatarioRepository tecnicoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public Locatario findById(Integer id) {
		Optional<Locatario> obj = tecnicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}
	public List<Locatario> findAll() {
		return tecnicoRepository.findAll();
	
	}
	public Locatario create(LocatarioDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(passwordEncoder.encode(objDTO.getSenha()));
		validaPorCpfEEmail(objDTO);
		Locatario newObj = new Locatario(objDTO);
		return tecnicoRepository.save(newObj);
	}
	
	public Locatario update(Integer id, @Valid LocatarioDTO objDTO) {
		objDTO.setId(id);
		Locatario oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Locatario(objDTO);
		return tecnicoRepository.save(oldObj);
		
		
	}
	public void delete(Integer id) {
		Locatario obj = findById(id);
		if(obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("Técnico possui ordens de serviço associada ao seu registro e não pode ser deletado!");
		}
		 tecnicoRepository.deleteById(id);
		
	}
	private void validaPorCpfEEmail(LocatarioDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
		}
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
		}
	}
	
	
	
	
	
}
