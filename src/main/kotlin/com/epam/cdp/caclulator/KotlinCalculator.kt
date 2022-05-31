package com.epam.cdp.caclulator

import com.epam.cdp.caclulator.converter.SuffixExpressionConverter
import java.util.Stack;
import java.util.Optional;

class KotlinCalculator {

    fun calculate(input: String): String {
        val converter = SuffixExpressionConverter();
        val stack: Stack<Double> = Stack()
        val suffixExpression = converter.convert(input)
        Optional.ofNullable(suffixExpression)
            .orElse("")
            .toCharArray()
            .forEach { item ->
                when (item) {
                    '+' -> stack.push(stack.pop() + stack.pop())
                    '-' -> stack.push(stack.pop() - stack.pop())
                    '/' -> stack.push(stack.pop() / stack.pop())
                    '*' -> stack.push(stack.pop() * stack.pop())
                    else -> {
                        stack.push(item.toString().toDouble())
                    }
                }
            }

        return stack.pop().toString();
    }
}