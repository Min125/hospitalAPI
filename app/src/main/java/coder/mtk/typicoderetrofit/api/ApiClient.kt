package coder.mtk.typicoderetrofit.api

import coder.mtk.typicoderetrofit.model.Hospital
import coder.mtk.typicoderetrofit.model.HospitalDetail
import coder.mtk.typicoderetrofit.model.HospitalX
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "http://hospitalguideapi.dsv.hoz.mybluehost.me/api/"

    private val apiInterface : HospitalApiInterface

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            HospitalApiInterface::class.java
        )
    }

    fun getHospital () : Call<Hospital>{
        return apiInterface.getHospital()
    }

    fun getDetail (id : String) : Call<HospitalDetail>{
        return apiInterface.getDetails(id)
    }

}