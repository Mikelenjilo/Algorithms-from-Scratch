import kotlin.collections.emptyList

class BreadthFirstSearch<T>(val graph: Map<T, List<T>>) {
    fun search(start: T, condition: (T) -> Boolean) : T? {
        val searchQueue = ArrayDeque(graph[start] ?: emptyList())
        val searched = mutableSetOf<T>()

        if (searchQueue.isEmpty()) {
            throw Exception("start parameter value: $start, was not found in the graph.")
        }

        while (searchQueue.isNotEmpty()) {
            val t = searchQueue.removeFirstOrNull()
            if (t != null && t !in searched) {
                if (condition(t)) {
                    print("$t was found")
                    return t
                } else {
                    searched.add(t)
                    searchQueue.addAll(graph[t] ?: emptyList())
                }
            }
        }


        return null
    }
}

fun main() {
    val alice = Friend("Alice", false)
    val bob = Friend("Bob", false)
    val charlie = Friend("Charlie", true)
    val dave = Friend("Dave", false)
    val eve = Friend("Eve", true)
    val frank = Friend("Frank", false)
    val me = Friend("Me", false)

    val graph = mapOf(
        me      to listOf(alice, bob, charlie),
        alice   to listOf(dave, eve),
        bob     to listOf(frank),
        charlie to emptyList(),
        dave    to emptyList(),
        eve     to emptyList(),
        frank   to emptyList()
    )

    val bfs = BreadthFirstSearch<Friend>(graph)

    val result = bfs.search(me) { it.movieLover && it.label == "Eve"}
    if (result != null) {
        println(result)
    } else {
        println("No movie lover found with that condition")
    }
}

data class Friend(val label: String, val movieLover: Boolean)
