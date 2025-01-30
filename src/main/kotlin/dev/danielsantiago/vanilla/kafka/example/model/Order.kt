package dev.danielsantiago.vanilla.kafka.example.model

data class Order(
    val orderId: Long,
    val products: List<OrderProduct>,
    val totalPriceCents: Long,
    val costumer: Costumer
)
