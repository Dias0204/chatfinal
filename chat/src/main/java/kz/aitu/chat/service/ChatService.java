package kz.aitu.chat.service;

import kz.aitu.chat.model.Chat;
import kz.aitu.chat.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    public void add(Chat chat) {
        chatRepository.save(chat);
    }

    public void update(Chat chat) {
        chatRepository.save(chat);
    }

    public void delete(Chat chat) {
        chatRepository.delete(chat);
    }

}
