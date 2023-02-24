package calculater.validator

interface Validator {
    fun validate(list: MutableList<String>): Boolean
}