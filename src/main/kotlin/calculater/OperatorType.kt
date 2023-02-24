package calculater

enum class OperatorType(
    val operator: String,
    val calculate: (Int, Int) -> Int
) {
    PLUS("+", add),
    MINUS("-", minus),
    MULTIPLY("*", multiply),
    DIVIDE("/", divide);

    companion object {
        fun from(input: String): OperatorType {
            val operator = OperatorType.values().filter {
                it.operator == input
            }.takeIf {
                it.isNotEmpty()
            }?.get(0)

            return operator ?: throw IllegalArgumentException()
        }

        fun isConvertible(input: String): Boolean {
            println(input)
            return OperatorType.values().any {
                it.operator == input
            }
        }
    }
}

val add = {
        a: Int, b: Int -> a + b
}

val minus = {
        a: Int, b: Int -> a - b
}

val multiply = {
        a: Int, b: Int -> a * b
}

val divide = {
        a: Int, b: Int ->
    if(a % b !== 0) {
        throw IllegalArgumentException()
    }
    a / b
}

