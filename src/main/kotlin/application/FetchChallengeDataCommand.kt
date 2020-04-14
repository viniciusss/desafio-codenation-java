package com.company.application

import com.company.model.ChallengeData
import com.company.model.ChallengeDataRepository
import com.company.services.CodeNationService

class FetchChallengeDataCommand (
    private val service: CodeNationService,
    private val repository: ChallengeDataRepository
) {
    fun fetch(token: String): ChallengeData {
        var challengeData = this.repository.ofToken(token)
        if (challengeData == null) {
            val response = this.service.generateData(token).execute();

            if (!response.isSuccessful) {
                println("falhou")
                println(response.toString())
            }

            challengeData = response.body()!!
            this.repository.persist(challengeData)
        }


        return challengeData!!
    }
}