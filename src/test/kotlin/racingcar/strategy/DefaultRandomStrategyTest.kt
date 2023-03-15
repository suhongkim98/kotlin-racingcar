package racingcar.strategy

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.RacingCars

class DefaultRandomStrategyTest : DescribeSpec({

    describe("생성자는") {
        context("randomMaxValue가 0 이하라면") {
            val givenRandomMaxValue = 0

            it("IllegalArgumentException을 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    DefaultRandomStrategy(givenRandomMaxValue)
                }
            }
        }
    }
})
