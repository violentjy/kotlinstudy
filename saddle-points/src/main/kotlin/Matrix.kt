class Matrix(rowList: List<List<Int>>) {
    val saddlePoints = mutableSetOf<MatrixCoordinate>()

    init {
        val rows = rowList.mapIndexed { i, list ->
            list.mapIndexed { j, value ->
                MatrixValue(value, MatrixCoordinate(i, j))
            }
        }

        val columns = mutableListOf<List<MatrixValue>>()
        val size = rows.firstOrNull()?.size ?: 0

        for (i in 0..(size - 1)) {
            columns.add(rows.map { it[i] })
        }

        val rowMaxs = rows.map { row -> row.maxBy { it.value } }.filterNotNull()
        val columnMins = columns.map { column -> column.minBy { it.value } }.filterNotNull()

        val rowFilter = rowMaxs.filter { it.value == columnMins[it.coordinate.col].value }
                .map { it.coordinate }
        val columnFilter = columnMins.filter { it.value == rowMaxs[it.coordinate.row].value }
                .map { it.coordinate }

        saddlePoints.addAll(rowFilter)
        saddlePoints.addAll(columnFilter)
    }
}

data class MatrixValue(val value: Int, val coordinate: MatrixCoordinate)