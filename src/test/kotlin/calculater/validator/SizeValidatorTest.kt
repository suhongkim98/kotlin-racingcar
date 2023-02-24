package calculater.validator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SizeValidatorTest : DescribeSpec({
    val sizeValidator = SizeValidator()

    describe("validate 메서드는") {
        context("리스트가 비어있을 경우") {
            val list = mutableListOf<String>()
            it("false를 반환한다.") {
                sizeValidator.validate(list) shouldBe false
            }
        }

        context("리스트가 비어있지 않을 경우") {
            val list = mutableListOf<String>("1","+","2")
            it("true를 반환한다.") {
                sizeValidator.validate(list) shouldBe true
            }
        }
    }
})