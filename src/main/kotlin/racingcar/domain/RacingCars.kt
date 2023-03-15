package racingcar.domain

import racingcar.dto.RoundResult
import racingcar.strategy.RandomStrategy

class RacingCars(private val gambleThreshold: Int,
                 private val randomStrategy: RandomStrategy,
                 private val cars: List<Car>) {

    init {
        if(gambleThreshold > randomStrategy.max) throw IllegalArgumentException("차가 전진하는 가중치는 random 값 최대치보다 클 수 없습니다.")
    }

    fun playRound(): RoundResult {
        cars.forEach {
            val random = gambling()
            if(isMovable(random)) it.moveForward()
        }

        return RoundResult(cars.map { it.weight }.toList())
    }

    private fun isMovable(randomValue: Int): Boolean = randomValue >= gambleThreshold
    private fun gambling(): Int = randomStrategy.getRandomValue()
}