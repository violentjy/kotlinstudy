import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(var date: LocalDateTime) {
    init {
        date = date.plusSeconds(Math.pow(10.0, 9.0).toLong())
    }

    constructor(date: LocalDate): this(date.atStartOfDay())
}