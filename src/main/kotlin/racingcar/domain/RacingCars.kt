package racingcar.domain

import racingcar.dto.RoundResult
import java.util.*

class RacingCars(private val gambleThreshold: Int,
                 private val randomMaxValue: Int,
                 private val cars: List<Car>) {

    init {
        if(randomMaxValue <= 0) throw IllegalArgumentException("random 값 최대치는 0이하일 수 없습니다.")
        if(gambleThreshold > randomMaxValue) throw IllegalArgumentException("차가 전진하는 가중치는 random 값 최대치보다 클 수 없습니다.")
    }

    fun playRound(): RoundResult {
        cars.forEach {
            val random = gambling()
            if(isMovable(random)) it.moveForward()
        }

        return RoundResult(cars.map { it.weight }.toList())
    }

    private fun isMovable(randomValue: Int): Boolean = randomValue >= gambleThreshold
    private fun gambling(): Int = Random().nextInt(randomMaxValue)
}