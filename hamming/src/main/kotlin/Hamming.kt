import java.lang.IllegalArgumentException

class Hamming {
    companion object { // Singletone 으로 선언했으면 간단!
        fun compute(left: String, right: String) : Int {
            if (left.length != right.length) {
                throw IllegalArgumentException("left and right strands must be of equal length.")
            }

            // 이하 zip 활용했다면 아주 깔-끔하게 처리 가능!
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
