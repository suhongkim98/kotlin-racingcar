package racingcar.domain

import racingcar.dto.RoundResult
import racingcar.strategy.MovingCriteria

class RacingCars private constructor (
    private val movingCriteria: MovingCriteria,
    private val cars: List<Car>
) {

    fun playRound(): RoundResult {
        cars.forEach {
            moveRacingCar(it)
        }

        return RoundResult(cars.map { it.weight }.toList())
    }

    private fun moveRacingCar(car: Car) {
        if(movingCriteria.isMovable(car)) {
            car.moveForward()
        }
    }

    companion object Factory {
        fun create(movingCriteria: MovingCriteria,
                   length: Int): RacingCars {
            val cars: MutableList<Car> = mutableListOf()

            for (i in 0 until length) {
                cars.add(Car())
            }

            return RacingCars(movingCriteria, cars)
        }
    }
}