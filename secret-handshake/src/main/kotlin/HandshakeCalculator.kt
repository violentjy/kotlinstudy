object HandshakeCalculator {
    // Signal.values() 이용했다면 이 함수 필요없음!!
    private fun getSignal(index: Int, value: Int): Signal? {
        if (value == 0) return null

        return when (index) {
            0 -> Signal.WINK
            1 -> Signal.DOUBLE_BLINK
            2 -> Signal.CLOSE_YOUR_EYES
            else -> Signal.JUMP
        }
    }

    // 비트연산 활용했다면 이 과정도 필요없음!
    private fun getBinary(number: Int): ArrayList<Int> {
        if (number <= 1) return arrayListOf(number)

        val binary = getBinary(number / 2)
        binary.add(number % 2)
        return binary
    }

    fun calculateHandshake(number: Int): List<Signal> {
        val reverseBinary = getBinary(number).asReversed()

        val signals = reverseBinary
                .filterIndexed { index, i -> index < 4 }
                .mapIndexed { index, i -> if (i == 0) null else Signal.values()[index] }
                .filterNotNull()

        return if (reverseBinary.size > 4) {
            signals.reversed()
        } else {
            signals
        }
    }
}
