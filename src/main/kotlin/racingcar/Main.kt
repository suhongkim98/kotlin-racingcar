package racingcar

import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView


fun main() {
    val carCount = InputView.getCarCount()
    val round = InputView.getRoundCount()

    val result = RacingGame(carCount, round, 4, 9).start()

    ResultView.printRacingGameResult(result)
}