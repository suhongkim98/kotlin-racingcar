package calculater.validator

import calculater.OperatorType

class ExpressionValidator : Validator {

    private val isNumber = { input: String -> input.toIntOrNull() !== null }

    override fun validate(list: MutableList<String>): Boolean {
        return list.filter {
            !isNumber(it)
        }.all {
            OperatorType.isConvertible(it)
        }
    }
}


