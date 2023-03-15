package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import racingcar.strategy.DefaultRandomStrategy

internal class RacingCarsTest: DescribeSpec({
    val givenRandomMaxValue = 9

    describe("생성자는") {
        context("가중치가 randomMaxValue보다 크다면") {
            val givenGambleThreshold = 10
            val givenRandomStrategy = DefaultRandomStrategy(givenRandomMaxValue)

            it("IllegalArgumentException을 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    RacingCars(givenGambleThreshold, givenRandomStrategy, listOf(Car()))
                }
            }
        }
    }

    describe("playRound 메서드는") {
        context("정상적으로 호출이 되었다면") {
            val givenThreshold = 4
            val givenRandomStrategy = DefaultRandomStrategy(givenRandomMaxValue)
            val givenCars = listOf(Car(), Car(), Car(), Car(), Car())
            val racingCars = RacingCars(givenThreshold, givenRandomStrategy, givenCars)

            val expectSize = 5
            it("해당 라운드의 결과를 반환한다.") {
                val round = racingCars.playRound()

                round.moves.size shouldBe expectSize
            }
        }

        context("차를 전진시키기 위해 랜덤값을 불러왔을 때 설정한 임계치보다 크다면") {
            val givenThreshold = 4
            val givenCars = listOf(Car(), Car(), Car(), Car(), Car())
            val givenRandomStrategy = mockk<DefaultRandomStrategy>()
            val expectRandomValue = 5
            val expectCarMoveValue = 2

            every { givenRandomStrategy.max } returns givenRandomMaxValue
            every { givenRandomStrategy.getRandomValue() } returns expectRandomValue

            val racingCars = RacingCars(givenThreshold, givenRandomStrategy, givenCars)

            it("해당 Car를 전진시킨다.") {
                val roundResult = racingCars.playRound()

                roundResult.moves.forEach {
                    it shouldBe expectCarMoveValue
                }
            }
        }

        context("차를 전진시키기 위해 랜덤값을 불러왔을 때 설정한 임계치보다 작다면") {
            val givenThreshold = 4
            val givenCars = listOf(Car(), Car(), Car(), Car(), Car())
            val givenRandomStrategy = mockk<DefaultRandomStrategy>()
            val expectRandomValue = 3
            val expectCarMoveValue = 1

            every { givenRandomStrategy.max } returns givenRandomMaxValue
            every { givenRandomStrategy.getRandomValue() } returns expectRandomValue

            val racingCars = RacingCars(givenThreshold, givenRandomStrategy, givenCars)

            it("해당 Car는 전진하지 않는다.") {
                val roundResult = racingCars.playRound()

                roundResult.moves.forEach {
                    it shouldBe expectCarMoveValue
                }
            }
        }
    }
})