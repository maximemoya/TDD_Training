import org.junit.jupiter.api.Test
import strikt.api.*
import strikt.assertions.*

class FizzBuzz() {

    @Test
    fun number1(){
        expectThat(FizzBuzz(1)).isEqualTo("1")
    }

    @Test
    fun number3(){
        expectThat(FizzBuzz(3)).isEqualTo("Fizz")
    }

    @Test
    fun number5(){
        expectThat(FizzBuzz(5)).isEqualTo("Buzz")
    }

    @Test
    fun number6(){
        expectThat(FizzBuzz(6)).isEqualTo("Fizz")
    }

    @Test
    fun number15(){
        expectThat(FizzBuzz(15)).isEqualTo("FizzBuzz")
    }

}