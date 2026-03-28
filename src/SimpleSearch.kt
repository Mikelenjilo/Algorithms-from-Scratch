class SimpleSearch(
    val array: IntArray,
    val target: Int
) {
    fun run(): Int {
        var steps: Int = 0

        for (i in array.indices) {
            steps++
            if (array[i] == target) {
                println("Steps: $steps")
                return i
            }
        }

        return -1
    }
}