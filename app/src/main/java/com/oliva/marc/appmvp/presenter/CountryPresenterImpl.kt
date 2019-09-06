package com.oliva.marc.appmvp.presenter

import com.oliva.marc.appmvp.model.Country
import com.oliva.marc.appmvp.model.interactor.CountriesInteractor
import com.oliva.marc.appmvp.model.interactor.impl.CountriesInteractorImpl
import com.oliva.marc.appmvp.view.CountryView

class CountryPresenterImpl(var countryView: CountryView):CountryPresenter {

    private var countryInteractor: CountriesInteractor= CountriesInteractorImpl(this)

    override fun showCountries(countries:ArrayList<Country>?) {
        countryView.showCountries(countries)
    }

    override fun getCountries() {
        countryInteractor.getCountriesAPI()
    }

}