package calculater

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class OperatorTypeTest: DescribeSpec({
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

    describe("from 메서드는") {
        context("사칙연산 기호가 아닌 특수문자가 들어온 경우") {
            val given = "&"
            it("IllegalArgumentExcpetion을 발행한다.") {
                shouldThrow<IllegalArgumentException> {
                    OperatorType.from(given)
                }
            }
        }
        context("사칙연산 기호가 들어온 경우") {
            val given = "+"
            val expect = OperatorType.PLUS
            it("해당 enum 타입을 반환한다.") {
                OperatorType.from(given) shouldBe expect
            }
        }
    }

    describe("isConvertable 메서드는") {
        context("연산자로 변환가능한 문자라면") {
            val given = "+"
            it("true를 반환한다.") {
                OperatorType.isConvertible(given) shouldBe true
            }
        }

        context("연산자로 변환 불가능한 문자라면") {
            val given = "@"
            it("false를 반환한다.") {
                OperatorType.isConvertible(given) shouldBe false
            }
        }
    }
})