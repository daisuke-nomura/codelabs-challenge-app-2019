package droidkaigi.github.io.challenge2019.data.repository

import droidkaigi.github.io.challenge2019.data.api.HackerNewsApi
import droidkaigi.github.io.challenge2019.data.api.response.Item
import droidkaigi.github.io.challenge2019.data.api.response.User
import retrofit2.Call

class HackerNewsRepository(private val hackerNewsApi: HackerNewsApi) {

    fun getItem(id: Long): Call<Item> {
        return hackerNewsApi.getItem(id)
    }

    fun getUser(id: String): Call<User> {
        return hackerNewsApi.getUser(id)
    }

    fun getTopStories(): Call<List<Long>> {
        return hackerNewsApi.getTopStories()
    }

    fun getNewStories(): Call<List<Long>> {
        return hackerNewsApi.getNewStories()
    }

    fun getJobStories(): Call<List<Long>> {
        return hackerNewsApi.getJobStories()
    }
}