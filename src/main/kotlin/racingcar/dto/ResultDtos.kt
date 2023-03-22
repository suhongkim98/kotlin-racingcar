package racingcar.dto

data class CarStatusDto(
    val name: String,
    val weight: Int,
)


data class RoundResultDto(
    val carStatuses: List<CarStatusDto>
)
