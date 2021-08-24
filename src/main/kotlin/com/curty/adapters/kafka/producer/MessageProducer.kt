package com.curty.adapters.kafka.producer

import com.curty.avro.Client
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient(id="client-producer")
interface MessageProducer {

    @Topic("kaas-pubsub-demo")
    fun sendClient(@KafkaKey brand: String?, client: Client)
    fun sendClient(@Topic topic: String?, @KafkaKey brand: String?, client: Client)
}