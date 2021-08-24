package com.curty.application.api.controller

import com.curty.adapters.kafka.producer.MessageProducer
import com.curty.application.domain.ClientDTO
import com.curty.application.domain.JsonResponse
import com.curty.avro.Client
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import java.util.*

@Controller("rest")
class ClientRestEndpoint (private val messageProducer: MessageProducer){

    @Post("/create")
    @Produces(MediaType.APPLICATION_JSON)
    fun saveClient(@Body clientDTO: ClientDTO): HttpResponse<JsonResponse>{
        var client = clientDTO.toAvro()
        var brand = "my-client-"+ UUID.randomUUID()
        messageProducer.sendClient(brand, client)
        return HttpResponse
            .created(JsonResponse("Client " + client + "posted in topic " + brand, Date()))
    }
}