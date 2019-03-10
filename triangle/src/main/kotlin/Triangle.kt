import java.util.*

class Triangle(a: Double, b: Double, c:Double) {
    var isEquilateral = false
    var isIsosceles = false
    var isScalene = false

    init {
        val sides = doubleArrayOf(a, b, c)

        // 헐 require 란 게 있었네 짱이다! 아래는 require 이용한 코드
        // side length cannot be 0
        if (sides.contains(0.0)) throw IllegalArgumentException()
        // sides violate triangle inequality
        if (a + b + c <= 2 * (sides.max() ?: 0.0) ) throw IllegalArgumentException()

        // 내 코드 require 로만 바꾼 버전
        require(!sides.contains(0.0)
                && a + b + c > 2 * (sides.max() ?: 0.0))

        // 음수 처리까지 추가된 버전 1
        require(a > 0 && b > 0 && c > 0
                && a + b + c > 2 * (sides.max() ?: 0.0))

        // 음수 처리까지 추가된 버전 2
        require(sides.filter { it <= 0 }.isEmpty()
                && a + b + c > 2 * (sides.max() ?: 0.0))

        val sideList = sides.toList()
        Collections.rotate(sideList, 1)

        // 사실 이게 너무 써보고 싶었다 ㅎ
        val compares = sides.zip(sideList) { sideLeft, sideRight -> sideLeft == sideRight }.filter { it }

        isScalene = compares.isEmpty()
        isIsosceles = compares.isNotEmpty()
        isEquilateral = compares.size == 3
    }

    constructor(a: Int, b: Int, c: Int): this(a.toDouble(), b.toDouble(), c.toDouble())
}