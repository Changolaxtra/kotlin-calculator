package com.epam.cdp.caclulator.data

data class StringNumber(val number: String) {

    operator fun plus(otherNumber: StringNumber): String {
        return (number.toDouble() + otherNumber.toString().toDouble()).toString()
    }

    operator fun minus(otherNumber: StringNumber): String {
        return (number.toDouble() - otherNumber.toString().toDouble()).toString()
    }

    operator fun times(otherNumber: StringNumber): String {
        return (number.toDouble() * otherNumber.toString().toDouble()).toString()
    }

    operator fun div(otherNumber: StringNumber): String {
        return (number.toDouble() / otherNumber.toString().toDouble()).toString()
    }

}