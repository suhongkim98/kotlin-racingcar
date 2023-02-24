package calculater

import calculater.validator.ExpressionValidator
import calculater.validator.SizeValidator
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class StringCalculatorTest : DescribeSpec({
    val stringCalculator = StringCalculator(listOf(SizeValidator(), ExpressionValidator()))

    describe("prepare 메서드는") {
        context("입력값이 null이거나 빈 공백 문자일 경우") {
            val given = ""

            it("IllegalArggumentException을 발행한다.") {
                shouldThrow<IllegalArgumentException> {
                    stringCalculator.prepare(given)
                }
            }
        }

        context("사칙연산 기호와 숫자 사이에 공백이 없다면") {
            val given = "1 + 2* 3"

            it("IllegalArgumentExcpetion을 발행한다.") {
                shouldThrow<IllegalArgumentException> {
                    stringCalculator.prepare(given)
                }
            }
        }
    }

    describe("parse 메서드는") {
        context("연산 처리에 정상적인 문자열이 들어온다면") {
            val given = "1 + 2 * 3 / 3"
            val expect = 3
            stringCalculator.prepare(given)

            it("연산을 하여 반환한다.") {
                stringCalculator.calculate() shouldBe expect
            }
        }
    }
})