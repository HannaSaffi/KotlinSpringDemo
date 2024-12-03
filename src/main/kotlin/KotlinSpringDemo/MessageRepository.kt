// MessageRepository.kt
package KotlinSpringDemo

import org.springframework.data.repository.CrudRepository

interface MessageRepository : CrudRepository<Message, String>