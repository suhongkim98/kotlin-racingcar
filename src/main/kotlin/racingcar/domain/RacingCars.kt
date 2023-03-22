package racingcar.domain

import racingcar.dto.CarStatusDto
import racingcar.dto.RoundResultDto
import racingcar.strategy.MovingCriteria

class RacingCars private constructor (
    private val movingCriteria: MovingCriteria,
    private val cars: List<Car>
) {

    fun playRound(): RoundResultDto {
        cars.forEach {
            moveRacingCar(it)
        }

        return RoundResultDto(cars.map {
            CarStatusDto(it.name, it.weight)
        })
    }

    private fun moveRacingCar(car: Car) {
        if(movingCriteria.isMovable(car)) {
            car.moveForward()
        }
    }

    companion object Factory {
        fun create(movingCriteria: MovingCriteria,
                   names: List<String>): RacingCars {
            val cars: MutableList<Car> = mutableListOf()

            for (name in names) {
                cars.add(Car(name))
            }

            return RacingCars(movingCriteria, cars)
        }
    }
}