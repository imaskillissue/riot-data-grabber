import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*
import requests.ExpandingAccountIDs

object VStats
{
	lateinit var key: String
	lateinit var client: HttpClient

	fun load()
	{
		key = javaClass.getResource("/key")?.readText() ?: throw Exception("No key found")
		client = HttpClient(Java) {
			install(ContentNegotiation) {
				gson()
			}
		}
	}
	fun makeRequest()
	{
		ExpandingAccountIDs()
	}
}

