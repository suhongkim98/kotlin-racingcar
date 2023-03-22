package racingcar.model

import racingcar.domain.RacingCars
import racingcar.dto.RoundResult
import racingcar.strategy.MovingCriteria

class RacingGame(
    movingCriteria: MovingCriteria,
    private val roundCount: Int,
    carNames: List<String>
) {

    private val racingCars: RacingCars

    init {
        if(carNames.isEmpty()) {
            throw IllegalArgumentException("레이싱을 진행하는 자동차의 개수는 0이하일 수 없습니다.")
        }

        racingCars = RacingCars.create(movingCriteria, carNames)
    }

    fun start(): List<RoundResult> {
        val result = mutableListOf<RoundResult>()

        for (i in 0 until roundCount) {
            val roundResult: RoundResult = racingCars.playRound()

            result.add(roundResult)
        }

        return result
    }
}