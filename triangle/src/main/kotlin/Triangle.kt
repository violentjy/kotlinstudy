import java.util.*

class Triangle(a: Double, b: Double, c:Double) {
    var isEquilateral = false
    var isIsosceles = false
    var isScalene = false

    init {
        val sides = doubleArrayOf(a, b, c)

        // side length cannot be 0
        if (sides.contains(0.0)) throw IllegalArgumentException()
        // sides violate triangle inequality
        if (a + b + c <= 2 * (sides.max() ?: 0.0) ) throw IllegalArgumentException()

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