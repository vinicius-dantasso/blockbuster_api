package br.edu.ufersa.blockbuster.domain.repoitory;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufersa.blockbuster.domain.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

    User findByUuid(UUID id);

    User findByEmail(String email);
    
}
