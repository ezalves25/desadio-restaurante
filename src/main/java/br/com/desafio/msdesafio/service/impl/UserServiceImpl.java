package br.com.desafio.msdesafio.service.impl;

import br.com.desafio.msdesafio.exceptions.UnauthorizedException;
import br.com.desafio.msdesafio.model.UserModel;
import br.com.desafio.msdesafio.repository.UserModelRepository;
import br.com.desafio.msdesafio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserModelRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserModelRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public UserModel createUser(UserModel user) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!isAdmin(authentication)) {
            throw new UnauthorizedException(null, "Apenas administradores podem excluir usuários.", "", "");
        }

        // Criar usuário com senha criptografada
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        return userRepository.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void updateUser(UserModel user) {
        // Verificar se o usuário atual possui permissão de administrador
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!isAdmin(authentication)) {
            throw new UnauthorizedException(null, "Apenas administradores podem excluir usuários.", "", "");
        }

        userRepository.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(Long userId) {
        // Verificar se o usuário atual possui permissão de administrador
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!isAdmin(authentication)) {
            throw new UnauthorizedException(null, "Apenas administradores podem excluir usuários.", "", "");
        }

        userRepository.deleteById(userId);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public UserModel getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    private boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ADMIN"));
    }
}
