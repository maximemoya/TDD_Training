
fun fizzBuzz(round: Int): String {

    var bufferResult = ""
    for(i in 1..round){

        bufferResult += if ( i % 3 == 0 && i % 5 == 0){
            "Fizz Buzz"
        }
        else{
            if( i % 3 == 0){
                "Fizz"
            }
            else if( i % 5 == 0){
                "Buzz"
            }
            else{
                i.toString()
            }
        }
        if (i != round){
            bufferResult += ", "
        }

    }
    return bufferResult

}

