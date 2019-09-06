package com.oliva.marc.appmvp.presenter

import com.oliva.marc.appmvp.model.Country

interface CountryPresenter {

    fun showCountries(countries:ArrayList<Country>?)
    fun getCountries()

}