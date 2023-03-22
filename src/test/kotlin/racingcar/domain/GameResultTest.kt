package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class GameResultTest : DescribeSpec({
    describe("findWinners 메서드는") {
        context("라운드들에 대한 결과가 주어진다면") {
            val givenFirstRoundResult = RoundResult(listOf(
                CarStatus("a", 10),CarStatus("b", 20),
            ))
            val givenLastRoundResult = RoundResult(listOf(
                CarStatus("a", 20),CarStatus("b", 30),
            ))
            val gameResult = GameResult(listOf(givenFirstRoundResult, givenLastRoundResult))

            it("마지막 라운드의 승리자를 반환한다.") {
                gameResult.findWinners() shouldBe givenLastRoundResult.findWinners()
            }
        }
    }
})