package com.oliva.marc.appmvp.model

import com.google.gson.JsonObject
import java.io.Serializable
import java.lang.Exception

class Country(countryJson:JsonObject?):Serializable{
    lateinit var name: String
    lateinit var uriFlag:String

    init {
        try {
            name = countryJson!!.get(NAME).asString
            uriFlag= countryJson.get(FLAG).asString

        }catch (e:Exception){
            e.printStackTrace()
        }

    }
    companion object{
        private val NAME = "name"
        private val FLAG = "flag"
    }
}