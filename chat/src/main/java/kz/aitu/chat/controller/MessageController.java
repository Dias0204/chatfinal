package kz.aitu.chat.controller;

import kz.aitu.chat.model.Message;
import kz.aitu.chat.service.AuthService;
import kz.aitu.chat.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/message")
public class MessageController {
    private final AuthService authService;
    private final MessageService messageService;

    @PostMapping({"/"})
    public ResponseEntity<?> add(@RequestBody Message message, @RequestHeader("auth") String token) {
        if (authService.isExistByToken(token)) {
            messageService.add(message);
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.ok("Error");
    }

    @PutMapping({""})
    public ResponseEntity<?> edit(@RequestBody Message message, @RequestHeader("auth") String token) {
        if (authService.isExistByToken(token)) {
            messageService.update(message);
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.ok("Error");
    }

    @DeleteMapping({"/"})
    public ResponseEntity<?> delete(@RequestBody Message message, @RequestHeader("auth") String token) {
        if (authService.isExistByToken(token)) {
            messageService.delete(message);
            return ResponseEntity.ok(message);
        }
        return ResponseEntity.ok("Error");
    }
}
