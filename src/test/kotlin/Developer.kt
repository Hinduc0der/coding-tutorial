open class Developer(WriteTime: Double) : Coder(WriteTime) {
    protected var bugs: Int = 6
    open fun bugCount() = bugs * WriteTime
}