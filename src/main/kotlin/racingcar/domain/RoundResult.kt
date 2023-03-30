package racingcar.domain


class RoundResult(
    val racingRecords: List<RacingRecord>
) {
    fun findWinners(): List<RacingRecord> {
        val winner = racingRecords.maxByOrNull {
            it.weight
        } ?: return listOf()

        return racingRecords.filter {
            it.weight == winner.weight
        }
    }
}