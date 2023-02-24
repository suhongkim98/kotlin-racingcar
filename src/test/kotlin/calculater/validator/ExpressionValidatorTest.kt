package calculater.validator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ExpressionValidatorTest : DescribeSpec({
    val expressionValidator = ExpressionValidator()

    describe("validate 메서드는") {
        context("리스트에서 숫자가 아닌 문자들이 모두 연산자로 변환이 가능하다면") {
            val list = mutableListOf("1", "+", "2", "*", "3")

            it("true를 반환한다.") {
                expressionValidator.validate(list) shouldBe true
            }
        }

        context("리스트에서 숫자가 아닌 문자들이 모두 연산자로 변환이 불가능하다면") {
            val list = mutableListOf("1", "+", "2", "@", "3")

            it("false를 반환한다.") {
                expressionValidator.validate(list) shouldBe false
            }
        }
    }
})