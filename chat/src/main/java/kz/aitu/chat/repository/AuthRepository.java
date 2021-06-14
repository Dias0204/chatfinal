package kz.aitu.chat.repository;

import kz.aitu.chat.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {

    Auth getByLoginAndPassword(String login, String password);
    Boolean existsByToken(String token);

}
