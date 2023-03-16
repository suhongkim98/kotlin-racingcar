package racingcar

import racingcar.model.RacingGame
import racingcar.strategy.RandomMovingCriteria
import racingcar.view.InputView
import racingcar.view.ResultView


fun main() {
    val carCount = InputView.getCarCount()
    val roundCount = InputView.getRoundCount()

    val result = RacingGame(
        movingCriteria = RandomMovingCriteria(max = 9, gambleThreshold = 4),
        roundCount = roundCount,
        carCount = carCount).start()

    ResultView.printRacingGameResult(result)
}