package racingcar.strategy

import racingcar.domain.Car
import java.security.SecureRandom

class RandomMovingCriteria(
    private val max: Int,
    private val gambleThreshold: Int
) : MovingCriteria {

    init {
        if(max <= 0) throw IllegalArgumentException("random 값 최대치는 0이하일 수 없습니다.")
        if(gambleThreshold > max) throw IllegalArgumentException("차가 전진하는 가중치는 random 값 최대치보다 클 수 없습니다.")
    }

    override fun isMovable(car: Car): Boolean {
        val random = SecureRandom().nextInt(max)
        return random >= gambleThreshold
    }
}