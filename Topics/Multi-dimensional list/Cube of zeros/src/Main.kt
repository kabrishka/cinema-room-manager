fun main() {
    val mutableLists = mutableListOf(
        MutableList(3) { MutableList(3) { 0 } },
        MutableList(3) { MutableList(3) { 0 } },
        MutableList(3) { MutableList(3) { 0 } }
    )

    println(mutableLists)
}