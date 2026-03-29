class SelectionSort(
    val array: IntArray,
    val ascending: Boolean = true
) {
    private val sortedArray = mutableListOf<Int>()
    private val list = array.toMutableList()

    fun run(): IntArray {
        while (list.isNotEmpty()) {
            val value = if (ascending) findSmallestRemove() else findLargestRemove()
            sortedArray.add(value)
        }
        return sortedArray.toIntArray()
    }

    private fun findLargestRemove(): Int {
        var max = list[0]
        var index = 0

        for (i in 0 until list.size) {
            if (list[i] > max) {
                max = list[i]
                index = i
            }
        }

        list.removeAt(index)
        return max
    }

    private fun findSmallestRemove(): Int {
        var min = list[0]
        var index = 0

        for (i in 0 until list.size) {
            if (list[i] < min) {
                min = list[i]
                index = i
            }
        }

        list.removeAt(index)
        return min
    }
}