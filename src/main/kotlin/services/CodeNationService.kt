package com.company.services

import com.company.model.ChallengeData
import com.company.model.ChallengeDataScore
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*


interface CodeNationService {
    @GET("generate-data")
    fun generateData(
        @Query("token") token: String
    ): Call<ChallengeData>

    @Multipart()
    @POST("submit-solution")
    fun submitSolution(
        @Query("token") token: String,
        @Part answer: MultipartBody.Part
    ): Call<ChallengeDataScore>
}