package cinema

class Cinema(private val rows: Int,
             private val rowSeats: Int) {
    private val allSeats = MutableList(rows) {
        MutableList(rowSeats) { "S" }
    }
    private val countSeats = rows * rowSeats
    private var purchasedTickets = 0
    private var currentIncome = 0
    private val totalIncome = if(countSeats <= 60) {
        countSeats * 10
    } else {
        val premiumRows = (rows / 2)
        val otherRows = rows - premiumRows
        (premiumRows * 10 + otherRows * 8) * rowSeats
    }

    private var isRunning = true

    fun printAction() {
        while (isRunning) {
            println("""
            1. Show the seats
            2. Buy a ticket
            3. Statistics
            0. Exit
        """.trimIndent())
            when (readln().toInt()) {
                1 -> showSeats()
                2 -> buyTicket()
                3 -> showStatistics()
                0 -> {
                    isRunning = false
                    return
                }
            }
        }
    }

    private fun showSeats() {
        println("Cinema:")
        for(i in 0..rows) {
            for(j in 0..rowSeats) {
                if(i == 0 && j == 0) {
                    print("  ")
                } else if(i == 0) {
                    print("$j ")
                } else if(j == 0) {
                    print("$i ")
                } else {
                    print("${allSeats[i-1][j-1]} ")
                }
            }
            println()
        }
    }

    private fun buyTicket() {
        while(true) {
            try {
                println("Enter a row number:")
                val rowNumber = readln().toInt()
                println("Enter a seat number in that row:")
                val seatNumber = readln().toInt()

                if (allSeats[rowNumber - 1][seatNumber - 1] == "B") {
                    println("That ticket has already been purchased!")
                    continue
                }

                val income: Int = if (countSeats <= 60) {
                    10
                } else {
                    val premiumRows = (rows / 2)
                    if (rowNumber <= premiumRows) 10 else 8
                }

                currentIncome += income
                purchasedTickets += 1

                println("Ticket price: \$$income")

                allSeats[rowNumber - 1][seatNumber - 1] = "B"
                return
            } catch (e: IndexOutOfBoundsException) {
                println("Wrong input!")
                continue
            }
        }
    }

    private fun showStatistics() {
        println("""
            Number of purchased tickets: $purchasedTickets
            Percentage: ${"%.2f".format(purchasedTickets.toDouble()/countSeats * 100)}%
            Current income: $$currentIncome
            Total income: $$totalIncome
        """.trimIndent())
    }

}

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val rowSeats = readln().toInt()

    val cinema = Cinema(rows, rowSeats)
    cinema.printAction()
}

