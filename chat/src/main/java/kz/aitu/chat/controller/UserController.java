package kz.aitu.chat.controller;

import kz.aitu.chat.model.Auth;
import kz.aitu.chat.model.User;
import kz.aitu.chat.service.AuthService;
import kz.aitu.chat.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final AuthService authService;
    private final UserService userService;

    @GetMapping({"","/"})
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping({""})
    public ResponseEntity<?> add(@RequestBody User user) {
        userService.add(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping({""})
    public ResponseEntity<?> update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody User user, @RequestBody Auth auth) {
        authService.delete(auth);
        userService.delete(user);
        return ResponseEntity.ok(user);
    }


}
