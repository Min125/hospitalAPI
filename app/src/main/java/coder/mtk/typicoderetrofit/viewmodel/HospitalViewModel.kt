package coder.mtk.typicoderetrofit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import coder.mtk.typicoderetrofit.api.ApiClient
import coder.mtk.typicoderetrofit.model.Hospital
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HospitalViewModel : ViewModel(){
    private var hospital : MutableLiveData<Hospital> = MutableLiveData()

    fun getHospital() : LiveData<Hospital> = hospital

    fun loadHospital(){
        val apiClient = ApiClient()
        var apiCall = apiClient.getHospital()

        apiCall.enqueue(object : Callback<Hospital>{
            override fun onResponse(call: Call<Hospital>, response: Response<Hospital>) {
                hospital.value = response.body()
            }

            override fun onFailure(call: Call<Hospital>, t: Throwable) {
                Log.d("error",t.message.toString())
            }
        })
    }
}