object ScrabbleScore {
    fun getScoreUsingWhen(char: Char): Int {
        when (char) {
            'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> return 1
            'D', 'G' -> return 2
            'B', 'C', 'M', 'P' -> return 3
            'F', 'H', 'V', 'W', 'Y' -> return 4
            'K' -> return 5
            'J', 'X' -> return 8
            'Q', 'Z' -> return 10
        }
        
        return 0
    }

    fun getScoreUsingIf(char: Char): Int {
        return if (charArrayOf('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T').contains(char)) {
            1
        } else if (charArrayOf('D', 'G').contains(char)) {
            2
        } else if (charArrayOf('B', 'C', 'M', 'P').contains(char)) {
            3
        } else if (charArrayOf('F', 'H', 'V', 'W', 'Y').contains(char)) {
            4
        } else if (charArrayOf('K').contains(char)) {
            5
        } else if (charArrayOf('J', 'X').contains(char)) {
            8
        } else if (charArrayOf('Q', 'Z').contains(char)) {
            10
        } else {
            0
        }
    }
    
    fun scoreWord(input: String): Int {
        return input.map { getScoreUsingIf(it.toUpperCase()) }.fold(0) { sum, value ->
            sum + value
        }
    }
}