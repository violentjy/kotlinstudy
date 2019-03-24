object WordCount {
    fun phrase(input: String): Map<String, Int> {
        val words = input.split("""[^a-zA-Z0-9]{2,}|[^'a-zA-Z0-9]+""".toRegex())
                        .filter { it.isNotEmpty() }
                        .map { it.toLowerCase() }

        return words.phrase()
    }

    fun List<String>.phrase(): Map<String, Int> {
        val result = mutableMapOf<String, Int>()
        forEach { result.set(it, (result[it] ?: 0) + 1) }
        return result
    }

    fun List<String>.phraseSlow(): Map<String, Int> {
        return toSet().map { it to count { word -> it == word } }.toMap()
    }
}