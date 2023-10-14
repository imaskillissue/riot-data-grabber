import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*
import requests.ExpandingAccountIDs
import structures.Vec2
import util.Time

object VStats
{
	lateinit var key: String
	lateinit var client: HttpClient
	var requests = Vec2(0L, 0)

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
		if (requests.first + Time.MINUTE * 2 < System.currentTimeMillis())
		{
			requests.first = System.currentTimeMillis()
			requests.second = 0
		}
		if (requests.second > 85)
			return
		ExpandingAccountIDs()
	}
}

