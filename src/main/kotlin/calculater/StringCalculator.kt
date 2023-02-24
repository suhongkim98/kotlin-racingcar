package calculater

import calculater.validator.Validator

class StringCalculator(
    private val validators: List<Validator>
) {
    private var input: MutableList<String> = mutableListOf()

    fun prepare(input: String) {
        val list: MutableList<String> = split(input)

        val validation = validators.all {
            it.validate(list)
        }
        if(!validation) throw IllegalArgumentException()

        list.add(0, "+")
        this.input = list
    }

    private fun split(input: String) = input.split(" ")
        .takeIf {
            it.size > 1 || it[0].isNotEmpty()
        }?.toMutableList() ?: mutableListOf()

    fun calculate(): Int {
        var result = 0

        for(i in 0..input.lastIndex step 2) {
            val operator = OperatorType.toOperator(input[i])
            val operand = input[i + 1].toInt()
            result = operator.calculate(result, operand)
        }

        return result
    }
}