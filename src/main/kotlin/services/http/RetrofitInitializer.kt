package com.company.services.http
import com.company.services.CodeNationService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
            .client(this.client())
            .baseUrl("https://api.codenation.dev/v1/challenge/dev-ps/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun client(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    fun codeNationService() = retrofit.create(CodeNationService::class.java)
}