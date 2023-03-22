package racingcar.domain


class RoundResult(
    val carStatuses: List<CarStatus>
) {
    fun findWinners(): List<CarStatus> {
        val winner = carStatuses.maxByOrNull {
            it.weight
        } ?: return listOf()

        return carStatuses.filter {
            it.weight == winner.weight
        }
    }
}