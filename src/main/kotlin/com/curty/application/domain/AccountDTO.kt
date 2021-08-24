package com.curty.application.domain

data class AccountDTO(var id: Long?,
                      var clientDTO: ClientDTO?,
                      var balance: Float
                      ){

    constructor(id: Long?, balance: Float): this(
        id,
        ClientDTO(),
        balance
    )
}
