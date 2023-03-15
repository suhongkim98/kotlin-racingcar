package racingcar.domain

class Car {
    var weight: Int = 1
        private set

    fun moveForward() {
        this.weight++
    }
}