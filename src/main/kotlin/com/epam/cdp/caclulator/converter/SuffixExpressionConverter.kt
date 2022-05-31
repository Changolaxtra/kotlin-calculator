package com.epam.cdp.caclulator.converter

import java.util.Stack
import java.util.Optional

class SuffixExpressionConverter {

    val result: StringBuilder = StringBuilder();
    val stack: Stack<Char> = Stack();

    fun convert(input: String): String {
        Optional.ofNullable(input)
            .orElse("")
            .toCharArray()
            .forEach { item ->
                if (item.isDigit()) {
                    result.append(item);
                } else if (isLeftParenthesis(item)) {
                    stack.push(item);
                } else if (isOperator(item)) {
                    handleOperator(item);
                } else if (isRightParenthesis(item)) {
                    handleRightParenthesis();
                }
            }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    private fun isLeftParenthesis(char: Char): Boolean {
        return char == '(';
    }

    private fun isRightParenthesis(char: Char): Boolean {
        return char == ')';
    }

    private fun isOperator(char: Char): Boolean {
        return char == '+' || char == '-' || char == '/' || char == '*';
    }

    private fun handleOperator(char: Char) {
        if (!stack.isEmpty()) {
            val stackTop = stack.pop()
            if (compare(char, stackTop)) {
                stack.push(stackTop)
                stack.push(char)
            } else {
                result.append(stackTop)
                stack.push(char)
            }
        } else {
            stack.push(char)
        }
    }

    private fun compare(char: Char, stackTop: Char): Boolean {
        var hasPriority: Boolean = false
        if (stackTop == '(') {
            hasPriority = true;
        }
        if (char == '*' || char == '/') {
            if (stackTop == '+' || stackTop == '-') {
                hasPriority = true;
            }
        }
        return hasPriority;
    }

    private fun handleRightParenthesis() {
        while (!stack.isEmpty()) {
            val item = stack.pop()
            if (item != '(') {
                result.append(item)
            } else {
                break
            }
        }
    }


}