package kz.aitu.chat.service;

import kz.aitu.chat.model.User;
import kz.aitu.chat.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User add(User user){
        return this.userRepository.save(user);
    }

    public User update(User user){
        return this.userRepository.save(user);
    }

    public void delete(User user){
        this.userRepository.delete(user);
    }
}
