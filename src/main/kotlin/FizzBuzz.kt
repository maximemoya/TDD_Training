
fun FizzBuzz(round: Int): String {

    if( round % 3 == 0 && round % 5 == 0){
        return "FizzBuzz"
    }
    else if( round % 3 == 0){
        return "Fizz"
    }
    else if( round % 5 == 0){
        return "Buzz"
    }
    else{
        return round.toString()
    }

//    var bufferResult = ""
//    if( round % 3 == 0){
//        bufferResult += "Fizz"
//    }
//    if( round % 5 == 0){
//        bufferResult += "Buzz"
//    }
//    if( bufferResult == ""){
//        bufferResult = round.toString()
//    }
//    return bufferResult

}

