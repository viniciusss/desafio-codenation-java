package com.company.model

interface ChallengeDataRepository {
    fun ofToken(token: String): ChallengeData?;

    fun persist(challengeData: ChallengeData): ChallengeData;
}