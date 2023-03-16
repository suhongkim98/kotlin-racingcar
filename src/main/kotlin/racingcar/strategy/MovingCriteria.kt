package racingcar.strategy

import racingcar.domain.Car

interface MovingCriteria {
    fun isMovable(car: Car): Boolean
}