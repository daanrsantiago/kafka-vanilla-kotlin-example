package dev.danielsantiago.vanilla.kafka.example.consumer

import dev.danielsantiago.vanilla.kafka.example.model.Order
import org.apache.kafka.clients.consumer.KafkaConsumer
import java.time.Duration
import java.util.*


class OrderConsumer() {

    private val props = Properties()
    private val consumer: KafkaConsumer<String, Order>
    private val ORDER_TOPIC = "orders"

    init {
        props.setProperty("bootstrap.servers", "localhost:9092")
        props.setProperty("group.id", "test")
        props.setProperty("enable.auto.commit", "true")
        props.setProperty("auto.commit.interval.ms", "1000")
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
        props.setProperty("value.deserializer", "dev.danielsantiago.vanilla.kafka.example.config.deserializer.OrderDeserializer")

        consumer = KafkaConsumer(props)
        consumer.subscribe(listOf(ORDER_TOPIC))
    }

    fun listenToOrders(orderConsumerFunction: OrderConsumerFunction ) {
        while (true) {
            val consumerRecords = consumer.poll(Duration.ofMillis(100))
            consumerRecords.forEach {
                orderConsumerFunction.consume(it.value())
            }
        }
    }

    fun interface OrderConsumerFunction {
        fun consume(order: Order?)
    }

}