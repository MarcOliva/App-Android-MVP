package com.oliva.marc.appmvp.model.repository.impl

import com.google.gson.JsonArray
import com.oliva.marc.appmvp.model.Country
import com.oliva.marc.appmvp.model.repository.CountriesRepository
import com.oliva.marc.appmvp.model.repository.api.ReferenceCountryService
import com.oliva.marc.appmvp.presenter.CountryPresenter
import retrofit2.Call
import retrofit2.Response
import com.google.gson.JsonObject
import com.google.gson.JsonElement
import org.json.JSONObject
import retrofit2.Callback


class CountriesRepositoryImpl(var countryPresenter: CountryPresenter):CountriesRepository {
    override fun getCountriesAPI() {
        var countries :ArrayList<Country>? = ArrayList()
        val apiAdapter= ReferenceCountryService()
        val apiService = apiAdapter.getClientService()
        val call = apiService.listCountries()

        call.enqueue(object: Callback<JsonArray> {
            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {
                val countriesJsonArray = response.body()
                countriesJsonArray?.forEach { jsonElement:JsonElement->
                    val jsonObject= jsonElement.asJsonObject
                    val country = Country(jsonObject)
                    countries?.add(country)

                }
                countryPresenter.showCountries(countries)

            }

        })
    }

}