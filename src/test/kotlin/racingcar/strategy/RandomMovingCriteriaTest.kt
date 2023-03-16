package racingcar.strategy

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCars

class RandomMovingCriteriaTest : DescribeSpec({
    describe("생성자는") {
        context("가중치가 randomMaxValue보다 크다면") {
            val givenMax = 9
            val givenThreshold = 10
            it("IllegalArgumentException을 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    RandomMovingCriteria(max = givenMax, gambleThreshold = givenThreshold)
                }
            }
        }
    }
})
