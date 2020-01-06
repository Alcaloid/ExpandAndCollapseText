package com.codemobile.rcvcollab.database

import com.codemobile.rcvcollab.datatype.StarWarResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("people")
    fun getAllPeople(@Query("page") page: String):
            Call<StarWarResponse>

    companion object Factory {
        private val BASE_URL = "https://swapi.co/api/"

        private var retrofit: Retrofit? = null

        fun getClient(): ApiInterface {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(ApiInterface::class.java)
        }
    }
}