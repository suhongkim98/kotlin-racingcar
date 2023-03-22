package racingcar.view

import racingcar.domain.CarStatus
import racingcar.domain.GameResult
import racingcar.domain.RoundResult

object ResultView {

    fun printRacingGameResult(result: GameResult) {
        println("실행 결과")

        result.roundResults.map {
            printRoundResult(it)
        }

        printWinners(result.winners)
    }

    private fun printRoundResult(roundResult: RoundResult) {
        roundResult.carStatuses.forEach {
            draw(it)
        }

        println()
    }

    private fun draw(carStatus: CarStatus) {
        println(carStatus.name + " : " + "-".repeat(carStatus.weight))
    }

    private fun printWinners(winners: List<CarStatus>) {
        if (winners.isEmpty()) return

        val names = winners.joinToString(", ") { it.name }
        println("${names}가 최종 우승했습니다.")
    }
}
