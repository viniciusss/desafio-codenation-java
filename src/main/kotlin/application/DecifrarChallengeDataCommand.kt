package com.company.application

import com.company.model.ChallengeData
import com.company.services.krypto.Krypto

class DecifrarChallengeDataCommand (val krypto: Krypto) {
    fun decifrar(data: ChallengeData): ChallengeData {
        data.decifrar(this.krypto)
        return data;
    }
}