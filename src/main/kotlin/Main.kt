fun main(args: Array<String>) {
    println("VStats Entered")
    VStats.load()
    println(VStats.key)
    while (true)
    {
        VStats.makeRequest()
        Thread.sleep(30000)
    }
    println("VStats Exited")
}