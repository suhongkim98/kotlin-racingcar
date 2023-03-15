package racingcar.strategy

interface RandomStrategy {
    val max: Int
    fun getRandomValue(): Int
}