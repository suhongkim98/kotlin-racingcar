package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingGame
import racingcar.strategy.RandomMovingCriteria

internal class RacingGameTest: DescribeSpec({
    describe("생성자는") {
        context("자동차의 개수가 0 이하라면") {
            val givenMovingStrategy = RandomMovingCriteria(max = 9, gambleThreshold = 4)
            val givenRound = 5
            val givenNames = listOf<String>()

            it("IllegalArgumentException을 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    RacingGame(
                        movingCriteria = givenMovingStrategy,
                        roundCount = givenRound,
                        carNames = givenNames
                    )
                }
            }
        }

        describe("start 메서드는") {
            context("정상적으로 호출된다면") {
                val givenMovingStrategy = RandomMovingCriteria(max = 9, gambleThreshold = 4)
                val givenRound = 5
                val givenNames = listOf("a","b")
                val racingGame = RacingGame(
                    movingCriteria = givenMovingStrategy,
                    roundCount = givenRound,
                    carNames = givenNames
                )

                it("모든 라운드에 대한 결과를 반환한다.") {
                    val roundResults = racingGame.start()

                    roundResults.roundResults.size shouldBe givenRound
                }
            }
        }
    }
})