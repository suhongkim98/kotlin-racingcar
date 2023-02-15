package utils

import java.util.regex.Matcher
import java.util.regex.Pattern

class StringAddCalculator {
    companion object {
        private const val CUSTOM_SEPARATOR_PATTERN = "//(.)\n(.*)"
        private val DEFAULT_DELIMITERS = arrayOf(",", ":")
        private val regex = Regex(CUSTOM_SEPARATOR_PATTERN)

        fun splitAndSum(input: String?): Int {
            if (input.isNullOrEmpty()) {
                return 0
            }

            val target = getTarget(input)
            val separator = getSeparators(input)

            try {
                return getSum(target, separator = separator)
            } catch (e: NumberFormatException) {
                throw RuntimeException()
            }
        }

        private fun getTarget(input: String): String = if (isCustomSeparatorInput(input)) {
            regex.matchEntire(input)!!.groups[2]!!.value
        } else {
            input
        }

        private fun isCustomSeparatorInput(input: String): Boolean = regex.matches(input)

        private fun getSeparators(input: String): Array<String> = if (isCustomSeparatorInput(input)) {
            arrayOf(regex.matchEntire(input)!!.groups[1]!!.value)
        } else {
            DEFAULT_DELIMITERS
        }

        private fun getSum(target: String, vararg separator: String): Int {
            var sum = 0
            for (item in target.split(delimiters = separator)) {
                val value = item.toInt()
                if (value < 0) throw RuntimeException()
                sum += value
            }
            return sum
        }
    }
}