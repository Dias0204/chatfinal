package kz.aitu.chat.controller;

import kz.aitu.chat.model.Chat;
import kz.aitu.chat.service.AuthService;
import kz.aitu.chat.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/chat")
public class ChatController {
    private final AuthService authService;
    private final ChatService chatService;

    @PostMapping({"/"})
    public ResponseEntity<?> add(@RequestBody Chat chat, @RequestHeader("auth") String token) {
        if (authService.isExistByToken(token)) {
            chatService.add(chat);
            return ResponseEntity.ok(chat);
        }
        return ResponseEntity.ok("Error");
    }

    @PutMapping({"/"})
    public ResponseEntity<?> Update(@RequestBody Chat chat, @RequestHeader("auth") String token) {
        if (authService.isExistByToken(token)) {
            chatService.update(chat);
            return ResponseEntity.ok(chat);
        }
        return ResponseEntity.ok("Error");
    }

    @DeleteMapping({"/"})
    public ResponseEntity<?> delete(@RequestBody Chat chat, @RequestHeader("auth") String token) {
        if (authService.isExistByToken(token)) {
            chatService.delete(chat);
            return ResponseEntity.ok(chat);
        }
        return ResponseEntity.ok("Error");
    }

}
