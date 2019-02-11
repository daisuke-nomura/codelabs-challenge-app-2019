package droidkaigi.github.io.challenge2019

import android.app.Application
import com.facebook.stetho.Stetho
import droidkaigi.github.io.challenge2019.data.api.HackerNewsApi
import droidkaigi.github.io.challenge2019.data.repository.HackerNewsRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import timber.log.Timber.DebugTree


class MyApplication : Application() {

    private lateinit var hackerNewsRepository: HackerNewsRepository

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
            Stetho.initializeWithDefaults(this)
        }
    }

    fun createRetrofit(url: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun getRepository(): HackerNewsRepository {
        if (!this::hackerNewsRepository.isInitialized) {
            val retrofit = createRetrofit("https://hacker-news.firebaseio.com/v0/")
            hackerNewsRepository = HackerNewsRepository(retrofit.create(HackerNewsApi::class.java))
        }

        return hackerNewsRepository
    }
}