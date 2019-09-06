package com.oliva.marc.appmvp.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.ahmadrosid.svgloader.SvgLoader
import com.oliva.marc.appmvp.R
import com.oliva.marc.appmvp.model.Country
import java.io.InputStream

class CountryRecyclerAdapter(var mContext: Context, var mListCountry: ArrayList<Country>?,var mActivity:MainActivity) :

    RecyclerView.Adapter<CountryRecyclerAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.item_country,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mListCountry?.size?:0
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentCountry = mListCountry?.get(position)
        holder.setDataCountry(currentCountry,mActivity)
    }


    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private var country:Country?=null
        private var mNameCountry = itemView.findViewById<TextView>(R.id.name_country_textview)
        //private var mFlagCountry = itemView.findViewById<WebView>(R.id.flag_webview)
        private var mFlagCountry = itemView.findViewById<ImageView>(R.id.flag_imageview)

        init {
            itemView.setOnClickListener(this)
        }
        fun setDataCountry(country: Country?,mActivity: MainActivity){
            this.country=country
            mNameCountry.text = country?.name
            //mFlagCountry.loadUrl(country?.uriFlag)
            SvgLoader.pluck()
                .with(mActivity)
                .setPlaceHolder(R.drawable.loading_spinner,R.drawable.loading_spinner)
                .load(country?.uriFlag, mFlagCountry)


        }
        override fun onClick(p0: View) {
            val context= p0.context
            val showCountryIntent = Intent(context,DetailCountryActivity::class.java)
            showCountryIntent.putExtra("country",country)
            context.startActivity(showCountryIntent)
        }


    }


}