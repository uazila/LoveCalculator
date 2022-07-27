package kg.example.lovecalculator.network

import kg.example.lovecalculator.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculate(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-key") key: String = "319c507c26mshcc5cbb722532a0ep11a1ecjsn2703c8c3fc41",
        @Header("X-RapidAPI-host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>

}



