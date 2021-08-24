package com.curty.adapters.kafka.serializer

import com.curty.avro.Client
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer

class ClientSerializer: Serializer<Client> {
    override fun serialize(topic: String?, data: Client?): ByteArray?{
        try {
            return ObjectMapper().writeValueAsBytes(data)
        } catch (e: JsonProcessingException){
            e.printStackTrace()
        }
        return null
    }
}