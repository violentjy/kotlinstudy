object Flattener {
    tailrec fun flatten(inputs: List<Any?>): List<Any?> {
        if (!inputs.any { it is List<Any?> }) {
            return inputs
        }

        return flatten(inputs
                .flatMap { if (it is List<Any?>) it.toList() else listOf(it) }
                .filterNotNull())
    }
}