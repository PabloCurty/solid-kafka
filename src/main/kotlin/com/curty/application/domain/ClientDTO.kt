package com.curty.application.domain

import com.curty.avro.Client

data class ClientDTO(var id: Long?,
                     var cpf: String,
                     var name: String,
                     var accounts: List<AccountDTO>? = mutableListOf()
                    ){

    constructor(): this(
        -1,
        "",
        ""
    )

    fun toAvro():Client{
        return Client.newBuilder()
            .setId(this.id!!)
            .setCpf(this.cpf)
            .setName(this.name)
            .setAccounts(this.accounts.toString())
            .build()
    }
}
