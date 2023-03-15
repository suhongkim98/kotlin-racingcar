package racingcar.view

import racingcar.dto.RoundResult

class ResultView {
    companion object {
        fun printRacingGameResult(result: List<RoundResult>) {
            println("실행 결과")

            result.map {
                printRoundResult(it)
            }
        }

        private fun printRoundResult(roundResult: RoundResult) {
            roundResult.moves.forEach {
                draw(it)
            }

            println()
        }

        private fun draw(move: Int) {
            println("-".repeat(move))
        }
    }
}
