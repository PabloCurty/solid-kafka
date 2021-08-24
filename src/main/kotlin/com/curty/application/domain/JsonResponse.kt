package com.curty.application.domain

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.*

data class JsonResponse( val message: String,
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
                         val date: Date)
