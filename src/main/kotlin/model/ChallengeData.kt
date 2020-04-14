package com.company.model

import com.company.services.krypto.Krypto
import com.company.sha1

data class ChallengeData (
    val numero_casas: Int,
    val token: String,
    val cifrado: String,
    private var decifrado: String = "",
    private var resumo_criptografico: String = ""
) {
    fun toJson(): String {
        return """
            {
                "numero_casas": $numero_casas,
                "token": "$token",
                "cifrado": "$cifrado",
                "decifrado": "$decifrado",
                "resumo_criptografico": "$resumo_criptografico"
            }
        """.trimIndent()
    }

    fun decifrar(krypto: Krypto) {
        this.decifrado = krypto.decrypt(this.cifrado, this.numero_casas)
        this.resumo_criptografico = this.decifrado.sha1()
    }
}