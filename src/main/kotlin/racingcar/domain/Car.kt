package racingcar.domain

class Car(
    val name: String
) {
    var weight: Int = 1
        private set

    fun moveForward() {
        this.weight++
    }
}