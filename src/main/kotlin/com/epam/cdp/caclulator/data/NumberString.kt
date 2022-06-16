package com.epam.cdp.caclulator.data

data class NumberString(val numberString: String) {

    operator fun plus(value: NumberString?): NumberString {
        return NumberString((numberString.toDouble() + value.toString().toDouble()).toString())
    }

    operator fun minus(value: NumberString?): NumberString {
        return NumberString((numberString.toDouble() - value.toString().toDouble()).toString())
    }

    operator fun div(value: NumberString?): NumberString {
        return NumberString((numberString.toDouble() / value.toString().toDouble()).toString())
    }

    operator fun times(value: NumberString?): NumberString {
        return NumberString((numberString.toDouble() * value.toString().toDouble()).toString())
    }

    override fun toString(): String {
        return numberString
    }
}