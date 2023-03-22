package racingcar.domain

class GameResult(
    val roundResults: List<RoundResult>,
) {
    fun findWinners(): List<CarStatus> {
        return roundResults.last().findWinners()
    }
}
