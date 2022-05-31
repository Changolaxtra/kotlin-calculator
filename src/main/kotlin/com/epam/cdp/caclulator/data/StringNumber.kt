package com.epam.cdp.caclulator.data

data class StringNumber(val number: String) {

    operator fun plus(increment: String): String {
        return (number.toDouble() + increment.toDouble()).toString()
    }

    operator fun minus(increment: String): String {
        return (number.toDouble() - increment.toDouble()).toString()
    }

    operator fun times(increment: String): String {
        return (number.toDouble() * increment.toDouble()).toString()
    }

    operator fun div(increment: String): String {
        return (number.toDouble() / increment.toDouble()).toString()
    }

}