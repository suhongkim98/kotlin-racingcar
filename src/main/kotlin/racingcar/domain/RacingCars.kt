package racingcar.domain

import racingcar.dto.RoundResult
import java.util.*

class RacingCars(private val gambleThreshold: Int,
                 private val randomMaxValue: Int,
                 private val cars: List<Car>) {

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