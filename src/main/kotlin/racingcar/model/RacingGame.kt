package racingcar.model

import racingcar.domain.Car
import racingcar.domain.RacingCars
import racingcar.dto.RoundResult

class RacingGame(
    private val round: Int,
    carCount: Int,
    gambleThreshold: Int,
    randomMaxValue: Int) {

    private val racingCars: RacingCars

    init {
        if(carCount <= 0) throw IllegalArgumentException("레이싱을 진행하는 자동차의 개수는 0이하일 수 없습니다.")

        val cars: MutableList<Car> = mutableListOf()

        for (i in 0 until carCount) {
            cars.add(Car())
        }

        racingCars = RacingCars(gambleThreshold, randomMaxValue, cars)
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