package KotlinSpringDemo

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MessageService(private val db: MessageRepository) {

    // Fetch all messages
    fun findMessages(): List<Message> = db.findAll().toList()

    // Fetch a message by its ID
    fun findMessageById(id: String): Message? = db.findByIdOrNull(id)

    // Save a new message
    fun save(message: Message): Message = db.save(message)
}
