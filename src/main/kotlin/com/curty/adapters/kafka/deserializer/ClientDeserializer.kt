package com.curty.adapters.kafka.deserializer

import com.curty.avro.Client
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Deserializer

class ClientDeserializer: Deserializer<Client> {
    override fun deserialize(topic: String?, data: ByteArray?): Client? {
        try {
            return ObjectMapper().readValue(data, Client::class.java)
        }catch (e: Exception){
            e.printStackTrace()
        }
        return null
    }
}