import java.util.regex.Pattern
import kotlin.math.roundToInt

/**
 * The method can take 0, 1 or 2 numbers separated by comma, and returns their sum.
 * An empty string will return “0”.
 * Example of inputs: "", "1", "1.1,2.2".
 */
fun StringCalculator(number: String): String {

    if (number == "") {
        return "0"
    }

    var numberStrList = number.split("\n",",", ignoreCase = true)
    if (numberStrList[numberStrList.size - 1] == ""){
        return "Number expected but EOF found."
    }

    if (numberStrList.size == 1) {
        return numberStrList[0]
    }

    var numberDouble = 0.0
    for (str in numberStrList) {
        numberDouble += str.toDouble()
    }

    numberDouble = (((numberDouble * 1000).roundToInt()).toDouble()) /1000
    val result = numberDouble.toString()
    numberStrList = numberDouble.toString().split(".")

    return if (numberStrList[1] == "0"){
        numberStrList[0]
    }
    else{
        result
    }

}