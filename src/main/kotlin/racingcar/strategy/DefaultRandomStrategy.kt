package racingcar.strategy

import java.util.*

class DefaultRandomStrategy(
    override val max: Int
) : RandomStrategy {

    init {
        if(max <= 0) throw IllegalArgumentException("random 값 최대치는 0이하일 수 없습니다.")
    }

    override fun getRandomValue(): Int = Random().nextInt(max)
}