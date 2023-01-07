fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val n = readln().toInt()
    println((a..b).count { it % n == 0 })
}
