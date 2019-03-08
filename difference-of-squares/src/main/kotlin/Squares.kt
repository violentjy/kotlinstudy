class Squares(number: Int) {
    private val numbers = 0..number

    fun squareOfSum(): Int {
        return Math.pow(numbers.reduce { acc, i -> acc + i }.toDouble(), 2.0).toInt()
    }

    fun sumOfSquares(): Int {
        return numbers.map { it * it }.reduce { acc, i -> acc + i }
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}