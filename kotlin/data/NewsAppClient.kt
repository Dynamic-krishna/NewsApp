package data

import data.NewsApiClient.client
import data.model.News
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.utils.io.core.*
import utilis.Constents

object NewsApiClient {
    suspend fun getTopHeadlines(): News {
        val url = "https://newsapi.org/v2/top-headlines?country=in&apiKey=${Constents.API_Key}"
        return client.get(url).body()
    }

    suspend fun getSearchedNews(searchedInput: String): News {
        val url = "https://newsapi.org/v2/everything?q=$searchedInput&apiKey=${Constents.API_Key}"
//        val url = "https://newsapi.org/v2/top-headlines=$searchedInput?country=us&category=business&apiKey=${Constents.API_Key}"
        return client.get(url).body()
    }


    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

}
