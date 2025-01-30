package dev.danielsantiago.vanilla.kafka.example.model

data class OrderProduct(
    val product: Product,
    val amount: Int = 1
)
