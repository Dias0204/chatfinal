package kz.aitu.chat.service;

import kz.aitu.chat.model.Message;
import kz.aitu.chat.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public void add(Message message) {
        messageRepository.save(message);
    }

    public void update(Message message) {
        messageRepository.save(message);
    }

    public void delete(Message message) {
        messageRepository.delete(message);
    }

}
