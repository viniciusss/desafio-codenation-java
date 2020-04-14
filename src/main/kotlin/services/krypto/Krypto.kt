package com.company.services.krypto

class Krypto {

    fun decrypt (textoOriginal: String, numeroCasas: Int = 10): String {
        return apply(textoOriginal, (numeroCasas * -1));
    }

    fun encrypt (textoOriginal: String, numeroCasas: Int = 10): String {
        return apply(textoOriginal, numeroCasas);
    }

    private fun apply(texto: String, fator: Int): String
    {
        val encriptedText = StringBuilder();

        for (x in texto.decapitalize().toCharArray()) {
            encriptedText.append(
                applyToChar(x, fator)
            );
        }

        return encriptedText.toString();
    }

    private fun applyToChar(char: Char, fator: Int): Char {
        if (!char.isLetter()) {
            return char;
        }

        val asciiCharStartsIn = 97;
        val minValue = 97;
        val maxValue = 122;

        var novoChar = ((char.toInt()-asciiCharStartsIn+fator));

        if (0 > novoChar) {
            novoChar += maxValue;
        } else if (novoChar < minValue) {
            novoChar += minValue
        }

        return novoChar.toChar();
    }

}