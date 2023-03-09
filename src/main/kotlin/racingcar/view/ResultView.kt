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
            val moves = roundResult.moves

            for(move in moves) {
                draw(move)
            }
            println()
        }

        private fun draw(move: Int) {
            for (i in 0 until move) {
                print("-")
            }
            println()
        }
    }
}
