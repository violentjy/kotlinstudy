object WordCount {
    fun phrase(input: String): Map<String, Int> {
        // 1. toLowerCase 를 먼저 해줘도 된다
        // 2. 1의 방법으로 했으면 정규식에서 A-Z 가 필요없다.
        // 3. groupBy & mapValues 라는 함수가 있다...! 헉
        val words = input.split("""[^a-zA-Z0-9]{2,}|[^'a-zA-Z0-9]+""".toRegex())
                        .filter { it.isNotEmpty() }
                        .map { it.toLowerCase() }

        // 아래는 수정
        val result = input.toLowerCase()
                .split("""[^a-z0-9]{2,}|[^'a-z0-9]+""".toRegex())
                .filter { it.isNotEmpty() }
                .groupBy { it }
                .mapValues { it.value.size }

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