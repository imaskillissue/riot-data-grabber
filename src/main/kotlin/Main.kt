import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import util.Time
import kotlin.coroutines.CoroutineContext
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    println("VStats Entered")
    VStats.load()
    println(VStats.key)
    CoroutineScope(Dispatchers.Default).launch {
        scanConsole()
    }
    while (true)
    {
        VStats.makeRequest()
        Thread.sleep(15 * Time.SECOND)
        println("Requests: ${VStats.requests.second}")
    }
    println("VStats Exited")
}

suspend fun scanConsole()
{
    while (true)
    {
        val input = readlnOrNull()
        if (input == "exit")
            exitProcess(0)
    }
}