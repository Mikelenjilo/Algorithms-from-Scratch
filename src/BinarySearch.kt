class BinarySearch(
    val array: IntArray,
    val target: Int
) {
    fun run(): Int {
        var left: Int = 0
        var right: Int = array.size - 1
        var steps: Int = 0


        while (left <= right) {
            val center = (right + left) / 2
            val guess = array[center]
            steps++

            if (guess > target) {
                right = center - 1
            } else if (guess < target){
                left = center + 1
            } else {
                println("Steps: $steps")
                return center
            }
        }

        return -1
    }
}
