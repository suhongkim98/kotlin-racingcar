package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class RacingGameTest: DescribeSpec({
    describe("생성자는") {
        context("자동차의 개수가 0 이하라면") {
            val givenRound = 5
            val givenCarCount = 0
            val givenGambleThreshold = 4
            val givenRandomMaxValue = 9

            it("IllegalArgumentException을 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    RacingGame(givenRound, givenCarCount, givenGambleThreshold, givenRandomMaxValue)
                }
            }
        }

        describe("start 메서드는") {
            context("정상적으로 호출된다면") {
                val givenRound = 5
                val givenCarCount = 5
                val givenGambleThreshold = 4
                val givenRandomMaxValue = 9
                val racingGame = RacingGame(givenRound, givenCarCount, givenGambleThreshold, givenRandomMaxValue)

                it("모든 라운드에 대한 결과를 반환한다.") {
                    val roundResults = racingGame.start()

                    roundResults.size shouldBe givenRound
                }
            }
        }
    }
})