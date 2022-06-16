package com.epam.cdp.caclulator

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class KotlinCalculatorTest : FunSpec({
    withData(
        row("2+2*(5-7)", "6.0"),
        row("2+3*6", "20.0"),
        row("1+2*(4-3)", "-1.0"),
        row("2*3-9", "3.0"),
    ) { (expression, result) ->
        val calculator: KotlinCalculator = KotlinCalculator()
        calculator.calculate(expression) shouldBe result
    }
})