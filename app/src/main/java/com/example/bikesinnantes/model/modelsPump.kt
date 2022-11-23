package com.example.bikesinnantes.model

import android.location.Location
import kotlinx.serialization.*
import java.util.Date


var allPumps:List<Pump>? = null

@Serializable
data class Pump (
    val id: Long,
    val ville: String,
    val horaires_automate: String,
    val prix_maj: Date,
    val adresse: String,
    val prix: Double,
    val recordId: String,
    val carburant: String,
    val longitude : Double,
    val latitude: Double,
){
    fun toLocation(): Location {

        val location = Location("")

        location.latitude = latitude
        location.longitude = longitude

        return location
    }

}

