package racingcar.view

object InputView {

    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val names = readln().split(",")

        val validate = names.all {
            it.length <= 5
        }

        if (!validate) {
            throw IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.")
        }

        return names
    }

    fun getRoundCount(): Int {
        println("시도할 회수는 몇 회 인가요?")
        return readln().toInt()
    }
}