package coder.mtk.typicoderetrofit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coder.mtk.typicoderetrofit.api.ApiClient
import coder.mtk.typicoderetrofit.model.HospitalDetail
import coder.mtk.typicoderetrofit.model.HospitalX
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel(){
    private var detail : MutableLiveData<HospitalDetail> = MutableLiveData()

    fun getDetail() : LiveData<HospitalDetail> = detail

    fun loadDetail(id : String) {
        val apiClient = ApiClient()
        val apiCall = apiClient.getDetail(id)

        apiCall.enqueue(object : Callback<HospitalDetail>{
            override fun onResponse(call: Call<HospitalDetail>, response: Response<HospitalDetail>) {
                detail.value = response.body()
                Log.d("res",response.body().toString())
            }

            override fun onFailure(call: Call<HospitalDetail>, t: Throwable) {
                Log.d("DETAILERROR",t.message.toString())
            }

        })
    }
}