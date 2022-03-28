import org.junit.jupiter.api.Test
import strikt.api.*
import strikt.assertions.*

class FizzBuzzTest() {

    @Test
    fun number1() {
        expectThat(fizzBuzz(1)).isEqualTo("1")
    }

    @Test
    fun number3() {
        expectThat(fizzBuzz(3)).isEqualTo("1, 2, Fizz")
    }

    @Test
    fun number5() {
        expectThat(fizzBuzz(5)).isEqualTo("1, 2, Fizz, 4, Buzz")
    }

    @Test
    fun number6() {
        expectThat(fizzBuzz(6)).isEqualTo("1, 2, Fizz, 4, Buzz, Fizz")
    }

    @Test
    fun number15() {
        expectThat(fizzBuzz(15)).isEqualTo("1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz")
    }

    @Test
    fun number30() {
        expectThat(fizzBuzz(30)).isEqualTo(
            "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz," +
                    " 16, 17, Fizz, 19, Buzz, Fizz, 22, 23, Fizz, Buzz, 26, Fizz, 28, 29, Fizz Buzz"
        )
    }

}