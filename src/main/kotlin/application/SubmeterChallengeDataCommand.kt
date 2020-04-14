package com.company.application

import com.company.model.ChallengeData
import com.company.model.ChallengeDataScore
import com.company.services.CodeNationService
import com.company.services.http.ChallengeDataRequestBody

class SubmeterChallengeDataCommand (val service: CodeNationService) {

    fun submeter(data: ChallengeData): ChallengeDataScore {

        val requestBody = ChallengeDataRequestBody(data)
        val response = service.submitSolution(data.token, requestBody.multipartBody()).execute()

        if (!response.isSuccessful) {
            println("Deu ruim!")
        }

        return response.body()!!
    }

}