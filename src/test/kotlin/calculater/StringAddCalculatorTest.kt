package calculater

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import java.lang.RuntimeException

internal class StringAddCalculatorTest : DescribeSpec({

    describe("splitAndSum 메서드는") {

        context("null 이 주어지면") {
            val givenInput = null
            it("0을 반환한다.") {
                // test here
                StringAddCalculator.splitAndSum(givenInput) shouldBe 0
            }
        }

        context("빈 문자열이 주어지면") {
            val givenInput = ""
            it("0을 반환한다.") {
                // test here
                StringAddCalculator.splitAndSum(givenInput) shouldBe 0
            }
        }

        context("숫자 하나가 주어지면") {
            val givenInput = "1"
            it("그 숫자를 반환한다.") {
                // test here
                StringAddCalculator.splitAndSum(givenInput) shouldBe givenInput.toInt()
            }
        }

        context("쉼표 구분자(,)로 여러 숫자를 넣으면") {
            val givenInput = "1,2,3"
            it("그 숫자들의 합을 반환한다.") {
                // test here
                StringAddCalculator.splitAndSum(givenInput) shouldBe 6
            }
        }

        context("쉼표 구분자(,)와 콜론 구분자(:)를 둘 다 써서 여러 숫자를 넣으면") {
            val givenInput = "1,2:3"
            it("그 숫자들의 합을 반환한다.") {
                // test here
                StringAddCalculator.splitAndSum(givenInput) shouldBe 6
            }
        }

        context("문자열 앞부분의 '//'와 \\n 사이에 커스텀 구분자를 지정하여") {
            val givenInput = "//;\n1;2;3"
            it("그 숫자들의 합을 반환한다.") {
                // test here
                StringAddCalculator.splitAndSum(givenInput) shouldBe 6
            }
        }

        context("음수가 들어가면") {
            val givenInput = "-1"
            it("RuntimeException 을 발행한다.") {
                // test here
                shouldThrow<RuntimeException> {
                    StringAddCalculator.splitAndSum(givenInput)
                }
            }
        }

        context("숫자 이외에 문자가 들어가면") {
            val givenInput = "hello"
            it("RuntimeException 을 발행한다.") {
                // test here
                shouldThrow<RuntimeException> {
                    StringAddCalculator.splitAndSum(givenInput)
                }
            }
        }
    }

})