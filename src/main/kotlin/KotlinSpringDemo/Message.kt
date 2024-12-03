package KotlinSpringDemo

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("MESSAGES") // Maps this class to the "MESSAGES" table in the database
data class Message(
    val text: String, // Message text
    @Id val id: String? = null // Database primary key with a default value of null
)
