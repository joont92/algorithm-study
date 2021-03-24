package leetcode.easy

import java.util.*

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
fun main() {
    println(ValidParentheses().isValid("{}"))
    println(ValidParentheses().isValid("(){}[]"))
    println(ValidParentheses().isValid("[{()}]"))
    println(!ValidParentheses().isValid("(]"))
    println(!ValidParentheses().isValid("))"))
    println(!ValidParentheses().isValid("([)]"))
    println(!ValidParentheses().isValid("(((]"))
}

class ValidParentheses {
    fun isValid(s: String):Boolean {
        val stack = Stack<Char>()
        val chars = s.toCharArray()

        for (ch in chars) {
            if ("({[".indexOf(ch) != -1) {
                stack.push(ch)
            } else {
                if (stack.isEmpty()) {
                    return false
                }

                when (ch) {
                    ')' -> if (stack.peek() == '(') stack.pop() else return false
                    '}' -> if (stack.peek() == '{') stack.pop() else return false
                    ']' -> if (stack.peek() == '[') stack.pop() else return false
                }
            }
        }

        return stack.isEmpty()
    }
}