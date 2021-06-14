package kz.aitu.chat.repository;

import kz.aitu.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    User getUserByName(String name);
    User getUserById(Long id);



}
