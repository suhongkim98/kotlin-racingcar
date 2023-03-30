package racingcar.view

import racingcar.domain.RacingRecord
import racingcar.domain.GameResult
import racingcar.domain.RoundResult

object ResultView {

    fun printRacingGameResult(result: GameResult) {
        println("실행 결과")

        result.roundResults.forEach {
            printRoundResult(it)
        }

        printWinners(result.findWinners())
    }

    private fun printRoundResult(roundResult: RoundResult) {
        roundResult.racingRecords.forEach {
            draw(it)
        }

        println()
    }

    private fun draw(racingRecord: RacingRecord) {
        println(racingRecord.name + " : " + "-".repeat(racingRecord.weight))
    }

    private fun printWinners(winners: List<RacingRecord>) {
        if (winners.isEmpty()) return

        val names = winners.joinToString(", ") {
            it.name
        }
        println("${names}가 최종 우승했습니다.")
    }
}
