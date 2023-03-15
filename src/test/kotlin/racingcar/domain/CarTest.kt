package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

internal class CarTest: DescribeSpec({
    describe("moveForward 메서드는") {
        val car = Car()
        context("호출이 된다면") {
            val expectMove = car.weight + 1
            it("가중치가 1 올라간다.") {
                car.moveForward()

                car.weight shouldBe expectMove
            }
        }
    }
})