package com.who.to.whoToAPP.model

data class EventModel(

    var id: Long? = null,
    var title: String,
    var date: String,         // Usamos String si no necesitas manejar la fecha como tipo específico
    var time: String,         // Usamos String para la hora
    var description: String? = null,
    var maxAssistants: Int,
    var minAssistants: Int? = null
)
