package calculater.validator

class SizeValidator : Validator {
    override fun validate(list: MutableList<String>): Boolean = list.size != 0
}