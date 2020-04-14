package com.company.services.http

import com.company.model.ChallengeData
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody

class ChallengeDataRequestBody (val data: ChallengeData) {
    private fun requestBody(): RequestBody {
        return RequestBody.create(
            MediaType.parse("text/json"),
            data.toJson()
        )
    }

    fun multipartBody(): MultipartBody.Part {
        return MultipartBody.Part.createFormData("answer", "answer.json", this.requestBody());
    }
}