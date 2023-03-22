package racingcar.view

import racingcar.dto.CarStatusDto
import racingcar.dto.RoundResultDto

object ResultView {


    fun printRacingGameResult(result: List<RoundResultDto>) {
        println("실행 결과")

        result.map {
            printRoundResult(it)
        }
    }

    private fun printRoundResult(roundResult: RoundResultDto) {
        roundResult.carStatuses.forEach {
            draw(it)
        }

        println()
    }

    private fun draw(carStatus: CarStatusDto) {
        println(carStatus.name + " : " + "-".repeat(carStatus.weight))
    }
}
