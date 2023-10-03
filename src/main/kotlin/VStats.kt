import io.ktor.client.*

object VStats {
    lateinit var key: String
    lateinit var client: HttpClient

    fun load() {
        key = javaClass.getResource("/key")?.readText() ?: throw Exception("No key found")
        client = HttpClient()
    }

    fun makeRequest() {
        println("VStats.makeRequest() called")
    }
}