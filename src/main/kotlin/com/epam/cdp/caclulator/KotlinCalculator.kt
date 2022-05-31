package com.epam.cdp.caclulator

import com.epam.cdp.caclulator.converter.SuffixExpressionConverter
import com.epam.cdp.caclulator.data.StringNumber
import java.util.Stack;
import java.util.Optional;

class KotlinCalculator {

    fun calculate(input: String): String {
        val converter = SuffixExpressionConverter();
        val stack: Stack<StringNumber> = Stack()
        val suffixExpression = converter.convert(input)
        Optional.ofNullable(suffixExpression)
            .orElse("")
            .toCharArray()
            .forEach { item ->
                when (item) {
                    '+' -> stack.pop() + stack.pop()
                    '-' -> stack.pop() - stack.pop()
                    '/' -> stack.pop() / stack.pop()
                    '*' -> stack.pop() * stack.pop()
                    else -> {
                        stack.push(StringNumber(item.toString()))
                    }
                }
            }

        return stack.pop().toString();
    }
}