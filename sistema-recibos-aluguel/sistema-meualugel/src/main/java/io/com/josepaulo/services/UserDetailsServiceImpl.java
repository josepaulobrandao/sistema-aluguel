package io.com.josepaulo.services;

import io.com.josepaulo.config.UserSpringSecurity;
import io.com.josepaulo.domain.Pessoa;
import io.com.josepaulo.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PessoaRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Pessoa> user = repository.findByEmail(email);
        if(user.isPresent()){
            return new UserSpringSecurity(
                    user.get().getId(),
                    user.get().getEmail(),
                    user.get().getSenha(),
                    user.get().getPerfis());
        }
        throw new UsernameNotFoundException(email);
    }
}
