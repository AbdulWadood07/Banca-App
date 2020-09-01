package com.stechlabs.banca.apiService

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {


        const val BASE_URL="http://192.168.0.100:8080/api/"

        val retrofitBuilder=
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        val ApiService= retrofitBuilder.create(ApiService::class.java)
}