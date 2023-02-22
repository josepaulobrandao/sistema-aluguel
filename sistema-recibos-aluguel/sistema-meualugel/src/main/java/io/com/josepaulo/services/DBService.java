package io.com.josepaulo.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.com.josepaulo.domain.Chamado;
import io.com.josepaulo.domain.Locatario;
import io.com.josepaulo.domain.Tecnico;
import io.com.josepaulo.domain.enums.PerfilUsuario;
import io.com.josepaulo.domain.enums.PrioridadelChamado;
import io.com.josepaulo.domain.enums.StatusChamado;
import io.com.josepaulo.repositories.ChamadoRepository;
import io.com.josepaulo.repositories.PessoaRepository;
import io.com.josepaulo.repositories.TecnicoRepository;

@Service
public class DBService {
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private PessoaRepository pessaRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public  void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, " aldir Cezar", "aldir@mail.com", "550.482.150-95 ", passwordEncoder.encode("123"));
		tec1.addPerfil(PerfilUsuario.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Richard Stallman", "stallman@mail.com", " 903.347.070-56 ", passwordEncoder.encode("123"));
		Tecnico tec3 = new Tecnico(null, "Claude Elwood Shannon", "shannon@mail.com", "271.068.470-54",  passwordEncoder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "Tim Berners-Lee", "lee@mail.com ", "162.720.120-39",  passwordEncoder.encode("123"));
		Tecnico tec5 = new Tecnico(null, "Linus Tor alds", "linus@mail.com ", "778.556.170-27",  passwordEncoder.encode("123"));

		Locatario loc1 = new Locatario(null, "Albert Einstein", "einstein@mail.com", "111.661.890-74 ",  passwordEncoder.encode("123"));
		Locatario loc2 = new Locatario(null, "Marie Curie", "curie@mail.com", "322.429.140-06 ",  passwordEncoder.encode("123"));
		Locatario loc3 = new Locatario(null, "Charles Darwin", "darwin@mail.com", "792.043.830-62 ",  passwordEncoder.encode("123"));
		Locatario loc4 = new Locatario(null, "Stephen Hawking", "hawking@mail.com ", "177.409.680-30",  passwordEncoder.encode("123"));
		Locatario loc5 = new Locatario(null, "Max Planck", "planck@mail.com", "081.399.300-83",  passwordEncoder.encode("123"));
 
		Chamado c1 = new Chamado(null, PrioridadelChamado.MEDIA, StatusChamado.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, loc1);
		Chamado c2 = new Chamado(null, PrioridadelChamado.ALTA, StatusChamado.ABERTO, "Chamado 2", "Teste chamado 2", tec1, loc2);
		Chamado c3 = new Chamado(null, PrioridadelChamado.BAIXA, StatusChamado.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, loc3);
		Chamado c4 = new Chamado(null, PrioridadelChamado.ALTA, StatusChamado.ABERTO, "Chamado 4", "Teste chamado 4", tec3, loc3);
		Chamado c5 = new Chamado(null, PrioridadelChamado.MEDIA, StatusChamado.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, loc1);
		Chamado c6 = new Chamado(null, PrioridadelChamado.BAIXA, StatusChamado.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, loc5);

		pessaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, loc1, loc2, loc3, loc4, loc5 ));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6 ));
	}
}
