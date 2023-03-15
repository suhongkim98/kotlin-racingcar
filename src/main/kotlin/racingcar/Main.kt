package racingcar

import racingcar.model.RacingGame
import racingcar.strategy.DefaultRandomStrategy
import racingcar.view.InputView
import racingcar.view.ResultView


fun main() {
    val carCount = InputView.getCarCount()
    val round = InputView.getRoundCount()

    val result = RacingGame(
        randomStrategy = DefaultRandomStrategy(9),
        round = round,
        carCount = carCount,
        gambleThreshold = 4).start()

    ResultView.printRacingGameResult(result)
}