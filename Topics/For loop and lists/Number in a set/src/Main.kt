fun main() {
    val setOfValues = mutableSetOf<Int>()
    val countValues = readln().toInt()
    (0 until countValues).forEach { _ -> setOfValues.add(readln().toInt()) }
    val desiredValue = readln().toInt()
    println( if (setOfValues.contains(desiredValue)) "YES" else "NO")
}