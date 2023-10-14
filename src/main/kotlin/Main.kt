import util.Time

fun main(args: Array<String>) {
    println("VStats Entered")
    VStats.load()
    println(VStats.key)
    while (true)
    {
        VStats.makeRequest()
        Thread.sleep(15 * Time.SECOND)
        if (readlnOrNull() == "exit")
            break
    }
    println("VStats Exited")
}