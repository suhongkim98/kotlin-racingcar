package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class RacingCarsTest: DescribeSpec({
    describe("생성자는") {
        context("randomMaxValue가 0 이하라면") {
            val givenGambleThreshold = 4
            val givenRandomMaxValue = 0

            it("IllegalArgumentException을 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    RacingCars(givenGambleThreshold, givenRandomMaxValue, listOf(Car()))
                }
            }
        }

        context("가중치가 randomMaxValue보다 크다면") {
            val givenGambleThreshold = 10
            val givenRandomMaxValue = 9

            it("IllegalArgumentException을 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    RacingCars(givenGambleThreshold, givenRandomMaxValue, listOf(Car()))
                }
            }
        }
    }

    describe("playRound 메서드는") {
        context("정상적으로 호출이 되었다면") {
            val givenThreshold = 4
            val givenRandomMaxValue = 9
            val givenCars = listOf(Car(), Car(), Car(), Car(), Car())
            val racingCars = RacingCars(givenThreshold, givenRandomMaxValue, givenCars)

            val expectSize = 5
            it("해당 라운드의 결과를 반환한다.") {
                val round = racingCars.playRound()

                round.moves.size shouldBe expectSize
            }
        }
    }
})