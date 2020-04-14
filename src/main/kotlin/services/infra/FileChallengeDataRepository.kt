package com.company.services.infra

import com.company.model.ChallengeData
import com.company.model.ChallengeDataRepository
import com.google.gson.Gson
import java.io.File

class FileChallengeDataRepository (private val gson: Gson): ChallengeDataRepository {

    private fun file(token: String): File {
        return File(".data/answer-$token.json");
    }

    override fun ofToken(token: String): ChallengeData? {
        val answerFile = this.file(token)

        if (!answerFile.exists()) {
            return null
        }

        return this.gson.fromJson(
            answerFile.readText(),
            ChallengeData::class.java
        )
    }

    override fun persist(challengeData: ChallengeData): ChallengeData {
        val answerFile = this.file(challengeData.token)
        println(gson.toJson(challengeData))
        answerFile.writeText(challengeData.toJson())
        return challengeData
    }
}