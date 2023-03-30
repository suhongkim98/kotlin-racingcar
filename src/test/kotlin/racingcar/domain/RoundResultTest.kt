package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RoundResultTest : DescribeSpec({

    describe("findWinners 메서드는") {
        context("기록된 레이싱 카 정보가 없다면") {
            val givenStatus = listOf<RacingRecord>()
            val roundResult = RoundResult(givenStatus)
            it("빈 리스트를 반환한다.") {
                roundResult.findWinners().size shouldBe 0
            }
        }

        context("기록된 레이싱 카 정보가 있다면") {
            val givenStatus = listOf(
                RacingRecord("a", 2),
                RacingRecord("b", 3),
                RacingRecord("c", 3),
                RacingRecord("d", 3),
            )
            val roundResult = RoundResult(givenStatus)
            val expectSize = 3
            it("가장 앞서나가고 있는 차를 모두 반환한다.") {
                roundResult.findWinners().size shouldBe expectSize
            }
        }
    }
})
