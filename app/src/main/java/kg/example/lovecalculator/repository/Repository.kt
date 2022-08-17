package kg.example.lovecalculator.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kg.example.lovecalculator.App
import kg.example.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val loveModel = MutableLiveData<LoveModel>()

    fun doRequest(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        App.api.calculate(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                Log.e("ololo", "onResponce: ${response.body()}")
                loveModel.value = response.body()
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}")
            }
        })
        return loveModel
    }
}