package KotlinSpringDemo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/") // Base URL for all endpoints
class MessageController(private val service: MessageService) {

    // Handle GET request to fetch all messages
    @GetMapping
    fun listMessages(): ResponseEntity<List<Message>> = ResponseEntity.ok(service.findMessages())

    // Handle POST request to save a new message
    @PostMapping
    fun post(@RequestBody message: Message): ResponseEntity<Message> {
        val savedMessage = service.save(message)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }

    // Handle GET request to fetch a message by its id (dynamic endpoint)
    @GetMapping("/{id}")
    fun getMessage(@PathVariable id: String): ResponseEntity<Message> =
        service.findMessageById(id).toResponseEntity()

    // Handle GET request to fetch a message with a static endpoint for testing
    @GetMapping("/id")
    fun getSampleMessage(): ResponseEntity<Message> {
        val sampleId = "1" // Replace with a valid id from your database
        return service.findMessageById(sampleId).toResponseEntity()
    }

    // Helper function to convert a nullable Message to a ResponseEntity
    private fun Message?.toResponseEntity(): ResponseEntity<Message> =
        this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
}
