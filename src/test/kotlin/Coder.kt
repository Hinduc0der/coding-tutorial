open class Coder(val WriteTime: Double) {
    protected val PowerCode = 100
    fun calcLine(): Double {
        if (WriteTime < 0.0) {
            return 0.0
        }
        else return WriteTime * PowerCode
    }
}