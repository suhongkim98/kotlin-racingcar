package racingcar.domain

class GameResult(
    val roundResults: List<RoundResult>,
) {
    fun findWinners(): List<RacingRecord> {
        return roundResults.last().findWinners()
    }
}
