import java.time.LocalDate
import java.time.LocalDateTime

// constructor 통해서 받는 변수명은 따로 두고 date property 를 따로 만들어서 썼다면 더 가독성이 좋지 않았을까... 
class Gigasecond(var date: LocalDateTime) {
    init {
        date = date.plusSeconds(Math.pow(10.0, 9.0).toLong())
    }

    constructor(date: LocalDate): this(date.atStartOfDay())
}
