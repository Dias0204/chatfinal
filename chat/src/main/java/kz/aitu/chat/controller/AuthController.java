package kz.aitu.chat.controller;

import kz.aitu.chat.model.Auth;
import kz.aitu.chat.model.User;
import kz.aitu.chat.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Auth auth) {
        authService.add(auth);
        return ResponseEntity.ok(auth);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Auth auth) {
        authService.update(auth);
        return ResponseEntity.ok(auth);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Auth auth) {
        authService.delete(auth);
        return ResponseEntity.ok(auth);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestHeader("name") String name, @RequestHeader("login") String login, @RequestHeader("password") String password) {
        User user = authService.register(name,login,password);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestHeader("login") String login, @RequestHeader("password") String password) {
        String token = authService.login(login,password);
        return ResponseEntity.ok(token);
    }

}
