package com.oliva.marc.appmvp.model.interactor.impl

import com.oliva.marc.appmvp.model.interactor.CountriesInteractor
import com.oliva.marc.appmvp.model.repository.impl.CountriesRepositoryImpl
import com.oliva.marc.appmvp.presenter.CountryPresenter

class CountriesInteractorImpl(countryPresenter: CountryPresenter):CountriesInteractor {

    private var countriesRepository= CountriesRepositoryImpl(countryPresenter)
    override fun getCountriesAPI() {
       countriesRepository.getCountriesAPI()
    }

}