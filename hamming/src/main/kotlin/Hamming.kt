import java.lang.IllegalArgumentException

class Hamming {
    companion object {
        fun compute(left: String, right: String) : Int {
            if (left.length != right.length) {
                throw IllegalArgumentException("left and right strands must be of equal length.")
            }

            var num = 0

            for (i in left.toCharArray().indices) {
                if (left[i] != right[i]) {
                    num++
                }
            }

            return num
        }
    }
}
