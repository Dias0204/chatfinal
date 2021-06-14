package kz.aitu.chat.service;

import kz.aitu.chat.model.Auth;
import kz.aitu.chat.model.User;
import kz.aitu.chat.repository.AuthRepository;
import kz.aitu.chat.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final UserRepository userRepository;

    public void delete(Auth auth) {
        authRepository.delete(auth);
    }

    public void update(Auth auth) {
        authRepository.save(auth);
    }


    public void add(Auth auth) {
        authRepository.save(auth);
    }

    public User register(String name, String login, String password) {
        User user = userRepository.getUserByName(name);
        if (user != null){
            Auth auth = new Auth();
            auth.setLogin(login);
            auth.setPassword(password);
            auth.setUserId(user.getId());
            authRepository.save(auth);
            return user;
        }
        return null;
    }

    public String login(String login, String password) {
        Auth auth = authRepository.getByLoginAndPassword(login,password);
        if (auth != null){
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            auth.setToken(uuidAsString);
            authRepository.save(auth);
            return auth.getToken();
        }
        return null;
    }

    public Boolean isExistByToken(String token) {
        return authRepository.existsByToken(token);
    }
}
