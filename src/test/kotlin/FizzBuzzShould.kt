import org.junit.jupiter.api.Test
import strikt.api.*
import strikt.assertions.*

class FizzBuzzShould() {

    @Test
    fun `if number is 1 FizzBuzz return 1`(){
        expectThat(FizzBuzz(1)).isEqualTo("1")
    }

    @Test
    fun `if number is 3 FizzBuzz return Fizz`(){
        expectThat(FizzBuzz(3)).isEqualTo("Fizz")
    }

    @Test
    fun `if number is 5 FizzBuzz return Buzz`(){
        expectThat(FizzBuzz(5)).isEqualTo("Buzz")
    }

    @Test
    fun `if number is 6 FizzBuzz return Fizz`(){
        expectThat(FizzBuzz(6)).isEqualTo("Fizz")
    }

    @Test
    fun `if number is 15 FizzBuzz return FizzBuzz`(){
        expectThat(FizzBuzz(15)).isEqualTo("FizzBuzz")
    }

}