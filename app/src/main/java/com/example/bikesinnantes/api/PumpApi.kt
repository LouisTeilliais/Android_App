package com.example.bikesinnantes.api

import com.example.bikesinnantes.model.Pump
import retrofit2.Response
import retrofit2.http.GET

interface PumpApi {

    @GET("api/pumps")
    suspend fun getPumps():Response<List<Pump>>
}