package utils

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class StringCalculatorTest : DescribeSpec({
    describe("parse 메서드는") {
        context("입력값이 null이거나 빈 공백 문자일 경우") {
            it("IllegalArggumentException을 발행한다.") {
                shouldThrow<IllegalArgumentException> {
                    eval("")
                }
            }
        }

        context("사칙연산 기호가 아닌 특수문자가 들어온 경우") {
            it("IllegalArgumentExcpetion을 발행한다.") {
                shouldThrow<IllegalArgumentException> {
                    eval("1 + 2 @ 1")
                }
            }
        }

        context("사칙연산 기호와 숫자 사이에 공백이 없다면") {
            it("IllegalArgumentExcpetion을 발행한다.") {
                shouldThrow<IllegalArgumentException> {
                    eval("1 + 2* 3")
                }
            }
        }

        context("연산 처리에 정상적인 문자열이 들어온다면") {
            val given = "1 + 2 * 3 / 3"
            val expect = 3
            it("연산을 하여 반환한다.") {
                eval(given) shouldBe expect
            }
        }
    }

    describe("plus 메서드는") {
        context("두 인자가 주어진경우") {
            val givenA = 10
            val givenB = 20
            val expect = 30
            it("두 인자를 합한 값을 반환한다.") {
                add(givenA, givenB) shouldBe expect
            }
        }
    }

    describe("minus 메서드는") {
        context("두 인자가 주어진경우") {
            val givenA = 10
            val givenB = 20
            val expect = -10
            it("a에서 b를 뺀 값을 반환한다.") {
                minus(givenA, givenB) shouldBe expect
            }
        }
    }

    describe("multiply 메서드는") {
        context("두 인자가 주어진경우") {
            val givenA = 10
            val givenB = 20
            val expect = 200
            it("두 인자를 곱한 값을 반환한다.") {
                multiply(givenA, givenB) shouldBe expect
            }
        }
    }

    describe("divide 메서드는") {
        context("나누었을 때 정수로 나누어 떨어지지 않다면") {
            val givenA = 10
            val givenB = 3
            it("IllegalArgumentExcpetion을 발행한다.") {
                shouldThrow<IllegalArgumentException> {
                    divide(givenA, givenB)
                }
            }
        }

        context("두 인자가 주어진경우") {
            val givenA = 10
            val givenB = 5
            val expect = 2
            it("a에서 b를 나눈 값을 반환한다.") {
                divide(givenA, givenB) shouldBe expect
            }
        }
    }
})