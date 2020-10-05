package coder.mtk.typicoderetrofit.api

import coder.mtk.typicoderetrofit.model.Hospital
import coder.mtk.typicoderetrofit.model.HospitalDetail
import coder.mtk.typicoderetrofit.model.HospitalX
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HospitalApiInterface{

    @GET("hospital")
    fun getHospital() : Call<Hospital>

    @GET("hospital/{id}")
    fun getDetails(
        @Path("id") id : String
    ) : Call<HospitalDetail>

}