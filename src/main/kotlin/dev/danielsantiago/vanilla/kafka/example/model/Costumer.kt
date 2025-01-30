package dev.danielsantiago.vanilla.kafka.example.model

import java.util.Date

data class Costumer(
    val id: Long,
    val name: String,
    val birthDate: Date,
    val phoneNumber: String,
    val email: String,
    val address: String
)