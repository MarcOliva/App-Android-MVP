package com.oliva.marc.appmvp.model.repository.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReferenceCountryService{
    val urlApi = "https://restcountries.eu/rest/v2/"

    fun getClientService():CountriesService{
        var retrofit = Retrofit.Builder()
            .baseUrl(urlApi)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(CountriesService::class.java)
    }

}