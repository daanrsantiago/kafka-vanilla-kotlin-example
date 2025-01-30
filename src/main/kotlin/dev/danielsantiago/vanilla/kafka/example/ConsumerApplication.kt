package dev.danielsantiago.vanilla.kafka.example

import dev.danielsantiago.vanilla.kafka.example.consumer.OrderConsumer

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val orderConsumer = OrderConsumer()

    orderConsumer.listenToOrders {
        println(
            it.toString()
        )
    }
}