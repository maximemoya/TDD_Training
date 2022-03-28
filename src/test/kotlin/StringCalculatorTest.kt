import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class StringCalculatorTest(){

    // --------------
    // FIRST STEP :
    // ---------------

    // The method can take 0, 1 or 2 numbers separated by comma, and returns their sum.
    // An empty string will return “0”.
    // Example of inputs: "", "1", "1.1,2.2".

    @Test
    fun `if number is emptyString return str(0)`(){
        expectThat(StringCalculator("")).isEqualTo("0")
    }

    @Test
    fun `if there are 1 number return number`(){
        expectThat(StringCalculator("1")).isEqualTo("1")
    }

    @Test
    fun `if there are 2 numbers return addition of the 2 numbers`(){
        expectThat(StringCalculator("1.1,2.2")).isEqualTo("3.3")
    }

    // --------------
    // MANY NUMBERS :
    // ---------------

    // Allow the add method to handle an unknow number of arguments.

    @Test
    fun manyNumbers(){
        expectThat(StringCalculator("2,13,0.6,-12.5")).isEqualTo("3.1")
        expectThat(StringCalculator("2,0.5,-12.5,0,100,-50.5")).isEqualTo("39.5")
    }

    // ---------------------
    // NEWLINE AS SEPARATOR :
    // ----------------------

    // Allow the add method to handle newlines as separators:
    // "1\n2,3" should return "6".
    // "175.2,\n35" is invalid and
    // should return the message "Number expected but '\n' found at position 6."

    @Test
    fun newLineAsSeparator(){
        expectThat(StringCalculator("1\n2,3")).isEqualTo("6")
    }

    // --------------------------------
    // MISSING NUMBER IN LAST POSITION :
    // ---------------------------------

    // Don’t allow the input to end in a separator.
    // "1,3," is invalid and should return the message Number expected but EOF found.

    @Test
    fun missingNumberInLastPosition(){
        expectThat(StringCalculator("1,3,")).isEqualTo("Number expected but EOF found.")
    }

    // -----------------
    // Custom separators :
    // ------------------

    // Allow the add method to handle a different delimiter. To change the delimiter, the beginning of the input will contain a separate line that looks like this:
    //
    // //[delimiter]\n[numbers]
    // "//;\n1;2" should return "3"
    // "//|\n1|2|3" should return "6"
    // "//sep\n2sep3" should return "5"
    // "//|\n1|2,3" is invalid and should return the message "'|' expected but ',' found at position 3."

    @Test
    fun customSeparators_01(){
        expectThat(StringCalculator("//;\n1;2")).isEqualTo("3")
    }

}