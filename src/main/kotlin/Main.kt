package com.company

import com.company.application.DecifrarChallengeDataCommand
import com.company.application.FetchChallengeDataCommand
import com.company.application.SubmeterChallengeDataCommand
import com.company.model.ChallengeData
import com.company.services.CodeNationService
import com.company.services.http.ChallengeDataRequestBody
import com.company.services.http.RetrofitInitializer
import com.company.services.infra.FileChallengeDataRepository
import com.company.services.krypto.Krypto
import com.google.gson.Gson
import java.io.File
import java.security.MessageDigest


fun String.sha1(): String {
    val digestBytes = MessageDigest.getInstance("SHA-1").digest(this.toByteArray())
    return digestBytes.toHex()
}

fun ByteArray.toHex(): String {
    return joinToString("") { "%02x".format(it) }
}

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val token = "";

        val service = RetrofitInitializer().codeNationService();
        val repository = FileChallengeDataRepository(Gson());

        val fetch = FetchChallengeDataCommand(service, repository)
        val decifrar = DecifrarChallengeDataCommand(Krypto())
        val submeter = SubmeterChallengeDataCommand(service)

        val data = fetch.fetch(token)
        decifrar.decifrar(data)
        submeter.submeter(data)
    }
}