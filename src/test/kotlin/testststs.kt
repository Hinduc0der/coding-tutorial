fun main() {
    //println(enterCollects().min())
    val minims = listOf(2,35,76,42,1,6,8,8,35,56)
    val fruts = listOf("banana", "apple", "orange", "apple","lemon","apple")
    println(minofcollects(minims))
    println(frutolist(fruts))
}

//fun enterCollects(): List<Int> {
//    return readLine()!!.split(' ').map { it.toInt() }.toList()
//}

fun minofcollects(minims : List<Int>): Int{
    var min : Int
    var i : Int
    min = minims.sum()
  //  i = 0
    for (i in minims ) {
        if (i < min) {
            min = i
        }
    }
return min
}

fun frutolist (fruts : List<String>): Map<String, Int>{
return fruts.groupingBy {it}.eachCount()
}