package com.aysmdva.mvvm_jokesapp.api

import com.aysmdva.mvvm_jokesapp.model.Joke
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @GET("joke/Any")
    fun fetchJoke() : Call<Joke>
}