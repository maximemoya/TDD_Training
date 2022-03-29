import org.junit.jupiter.api.Test
import strikt.api.*
import strikt.assertions.*

class FizzBuzzTest() {

    @Test
    fun numberTo1() {
        expectThat(fizzBuzz(1,1)).isEqualTo("1")
    }

    @Test
    fun numberTo3() {
        expectThat(fizzBuzz(1,3)).isEqualTo("1, 2, Fizz")
    }

    @Test
    fun numberTo5() {
        expectThat(fizzBuzz(1,5)).isEqualTo("1, 2, Fizz, 4, Buzz")
    }

    @Test
    fun numberTo6() {
        expectThat(fizzBuzz(1,6)).isEqualTo("1, 2, Fizz, 4, Buzz, Fizz")
    }

    @Test
    fun numberTo15() {
        expectThat(fizzBuzz(1,15)).isEqualTo("1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz")
    }

    @Test
    fun numberTo30() {
        expectThat(fizzBuzz(1,30)).isEqualTo(
            "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz," +
                    " 16, 17, Fizz, 19, Buzz, Fizz, 22, 23, Fizz, Buzz, 26, Fizz, 28, 29, Fizz Buzz"
        )
    }

    @Test
    fun number0To5() {
        expectThat(fizzBuzz(0,5)).isEqualTo("0, 1, 2, Fizz, 4, Buzz")
    }

    @Test
    fun number3To15() {
        expectThat(fizzBuzz(3,15)).isEqualTo("Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz")
    }

}