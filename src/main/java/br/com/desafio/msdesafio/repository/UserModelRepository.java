package br.com.desafio.msdesafio.repository;

import br.com.desafio.msdesafio.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
    
}



