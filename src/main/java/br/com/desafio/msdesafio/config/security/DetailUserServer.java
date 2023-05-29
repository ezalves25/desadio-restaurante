package br.com.desafio.msdesafio.config.security;

import br.com.desafio.msdesafio.config.data.DetailUserData;
import br.com.desafio.msdesafio.model.UserModel;
import br.com.desafio.msdesafio.repository.UserModelRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetailUserServer implements UserDetailsService {

    private final UserModelRepository repository;

    public DetailUserServer(UserModelRepository repository) {
        this.repository = repository;
    }

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = repository.findByUsername(username);
        Optional<UserModel> optionalUserModel = Optional.of(userModel);
        if (optionalUserModel.isPresent()) {
            return new DetailUserData(optionalUserModel);

        }
        throw new UsernameNotFoundException("Usuario não encontrado");

    }
}
