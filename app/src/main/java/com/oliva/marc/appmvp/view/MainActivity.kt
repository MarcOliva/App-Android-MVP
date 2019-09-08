package com.oliva.marc.appmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oliva.marc.appmvp.R
import com.oliva.marc.appmvp.model.Country
import com.oliva.marc.appmvp.presenter.CountryPresenter
import com.oliva.marc.appmvp.presenter.CountryPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(),CountryView {


    private var countryPresenter: CountryPresenter? = null
    private var recyclerViewCountries: RecyclerView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        countryPresenter= CountryPresenterImpl(this)
        recyclerViewCountries= countries_recyclerview
        recyclerViewCountries?.layoutManager= GridLayoutManager(this,2)
        getCountries()

    }
    override fun getCountries() {
        countryPresenter?.getCountries()
    }
    override fun showCountries(countries: ArrayList<Country>?) {
        try {
            recyclerViewCountries?.adapter=CountryRecyclerAdapter(this, countries,this)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

}
