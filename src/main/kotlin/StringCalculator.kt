import java.lang.Exception
import java.util.regex.Pattern
import kotlin.math.roundToInt

/**
 * The method can take 0, 1 or 2 numbers separated by comma, and returns their sum.
 * An empty string will return “0”.
 * Example of inputs: "", "1", "1.1,2.2".
 */
fun StringCalculator(_number: String): String {

    if (_number == "") {
        return "0"
    }

    var number = _number
    var numberStrList: List<String>
    var isCustomDelimiter = false
    var customDelimiter = ""

    // check custom delimiter
    if (number[0] == '/' && number[1] == '/') {
        isCustomDelimiter = true
        val numberSplitCustomDelimiter = number.split("\n", limit = 2)
        customDelimiter = numberSplitCustomDelimiter[0].substring(2)
        number = numberSplitCustomDelimiter[1]
        numberStrList = number.split(customDelimiter, ignoreCase = true)
    } else {
        numberStrList = number.split("\n", ",", ignoreCase = true)
        // check first input
        if (numberStrList.size == 1) {
            return numberStrList[0]
        }
    }

    // check last input
    if (numberStrList[numberStrList.size - 1] == "") {
        return "Number expected but EOF found."
    }

    // check numbers to add or return exceptionDelimiter
    var numberDouble = 0.0
    for (i in numberStrList.indices) {
        try {
            numberDouble += numberStrList[i].toDouble()
        } catch (ignored: Exception) {
            if (isCustomDelimiter) {
                var wrongDelimiter = ""
                var indexWrongDelimiter = 0
                for (j in numberStrList[i].indices) {
                    if (!numberStrList[i][j].isDigit()) {
                        if (indexWrongDelimiter == 0) {
                            indexWrongDelimiter = i * (1 + customDelimiter.length) + j
                        }
                        wrongDelimiter += numberStrList[i][j]
                    }
                }
                return "'$customDelimiter' expected but '$wrongDelimiter' found at position ${indexWrongDelimiter}."
            }
        }
    }

    // RoundNumber to Format 0 or 0.1 or 0.01 or 0.001
    numberDouble = (((numberDouble * 1000).roundToInt()).toDouble()) / 1000
    val result = numberDouble.toString()
    numberStrList = numberDouble.toString().split(".")

    // return result
    return if (numberStrList[1] == "0") {
        numberStrList[0]
    } else {
        result
    }

}