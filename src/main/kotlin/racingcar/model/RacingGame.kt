package racingcar.model

import racingcar.domain.Car
import racingcar.domain.RacingCars
import racingcar.dto.RoundResult
import racingcar.strategy.RandomStrategy

class RacingGame(
    randomStrategy: RandomStrategy,
    private val round: Int,
    carCount: Int,
    gambleThreshold: Int) {

    private val racingCars: RacingCars

    init {
        if(carCount <= 0) {
            throw IllegalArgumentException("레이싱을 진행하는 자동차의 개수는 0이하일 수 없습니다.")
        }

        racingCars = RacingCars.create(gambleThreshold, randomStrategy, carCount)
    }

    fun start(): List<RoundResult> {
        val result = mutableListOf<RoundResult>()

        for (i in 0 until round) {
            val roundResult: RoundResult = racingCars.playRound()

            result.add(roundResult)
        }

        return result
    }
}