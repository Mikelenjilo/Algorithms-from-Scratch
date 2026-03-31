class QuickSort {
    fun run(arr: IntArray): IntArray {
       if (arr.size < 2) {
           return arr
       } else {
           val pivot = arr[0]
           val greater = mutableListOf<Int>()
           val less = mutableListOf<Int>()

           for (i in 1 until arr.size) {
               if (arr[i] >= pivot) {
                   greater.add(arr[i])
               } else {
                   less.add(arr[i])
               }
           }

           return run(less.toIntArray()) + intArrayOf(pivot) + run(greater.toIntArray())
       }
    }
}