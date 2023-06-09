package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import racingcar.strategy.RandomMovingCriteria

internal class RacingCarsTest: DescribeSpec({
    describe("playRound 메서드는") {
        context("정상적으로 호출이 되었다면") {
            val givenThreshold = 4
            val givenMovingStrategy = RandomMovingCriteria(max = 9, gambleThreshold = givenThreshold)
            val racingCars = RacingCars.create(givenMovingStrategy, listOf("a","b","c","d","e"))

            val expectSize = 5
            it("해당 라운드의 결과를 반환한다.") {
                val round = racingCars.playRound()

                round.racingRecords.size shouldBe expectSize
            }
        }

        context("차를 전진시키기 위한 조건에 만족한다면") {
            val givenMovingStrategy = mockk<RandomMovingCriteria>()
            val expectCarMoveValue = 2

            every { givenMovingStrategy.isMovable(any()) } returns true

            val racingCars = RacingCars.create(givenMovingStrategy, listOf("a","b","c","d","e"))

            it("해당 Car를 전진시킨다.") {
                val roundResult = racingCars.playRound()

                roundResult.racingRecords.forEach {
                    it.weight shouldBe expectCarMoveValue
                }
            }
        }

        context("차를 전진시키기 위한 조건에 만족하지 않는다면") {
            val givenMovingStrategy = mockk<RandomMovingCriteria>()
            val expectCarMoveValue = 1

            every { givenMovingStrategy.isMovable(any()) } returns false

            val racingCars = RacingCars.create(givenMovingStrategy, listOf("a","b","c","d","e"))

            it("해당 Car는 전진하지 않는다.") {
                val roundResult = racingCars.playRound()

                roundResult.racingRecords.forEach {
                    it.weight shouldBe expectCarMoveValue
                }
            }
        }
    }
})