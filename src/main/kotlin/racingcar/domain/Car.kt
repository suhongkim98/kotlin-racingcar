package racingcar.domain

class Car {
    var weight: Int = 0
        private set

    fun moveForward() {
        this.weight++
    }
}