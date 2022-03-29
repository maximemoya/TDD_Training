fun fizzBuzz(minNumber: Int, maxNumber: Int): String {

    var bufferResult = ""
    for (i in minNumber..maxNumber) {

        bufferResult +=
            when (i) {
                0 -> "0"
                else -> {
                    when (i % 15) {
                        0 -> "Fizz Buzz"
                        else -> {
                            when (i % 3) {
                                0 -> "Fizz"
                                else -> {
                                    when (i % 5) {
                                        0 -> "Buzz"
                                        else -> i.toString()
                                    }
                                }
                            }
                        }
                    }
                }
            }

        if (i != maxNumber) {
            bufferResult += ", "
        }

    }
    return bufferResult

}

fun fizzBuzzWithIf(round: Int): String {

    var bufferResult = ""
    for (i in 1..round) {

        bufferResult += if (i % 15 == 0) {
            "Fizz Buzz"
        } else {
            if (i % 3 == 0) {
                "Fizz"
            } else if (i % 5 == 0) {
                "Buzz"
            } else {
                i.toString()
            }
        }
        if (i != round) {
            bufferResult += ", "
        }

    }
    return bufferResult

}
