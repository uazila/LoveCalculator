package kg.example.lovecalculator

import android.app.Application
import kg.example.lovecalculator.network.LoveApi
import kg.example.lovecalculator.network.RetrofitService

class App: Application() {

    companion object{
        lateinit var api: LoveApi
    }

    override fun onCreate() {
        super.onCreate()
        val retrofit= RetrofitService()
        api =retrofit.api
    }
}