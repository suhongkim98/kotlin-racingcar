package racingcar.domain

import racingcar.strategy.MovingCriteria

class RacingCars private constructor (
    private val movingCriteria: MovingCriteria,
    private val cars: List<Car>
) {

    fun playRound(): RoundResult {
        cars.forEach {
            moveRacingCar(it)
        }

        return RoundResult(cars.map {
            CarStatus(it.name, it.weight)
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