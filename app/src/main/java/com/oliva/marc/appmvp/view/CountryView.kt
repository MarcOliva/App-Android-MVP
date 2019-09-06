package com.oliva.marc.appmvp.view

import com.oliva.marc.appmvp.model.Country

interface CountryView {
    fun getCountries()
    fun showCountries(countries:ArrayList<Country>?)
}