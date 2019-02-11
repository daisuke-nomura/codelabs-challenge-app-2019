package droidkaigi.github.io.challenge2019.data.pref

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit

class ArticlePreferences {

    companion object {

        private lateinit var p: SharedPreferences

        fun saveArticleIds(context: Context, articleId: String) {
            val p = PreferenceManager.getDefaultSharedPreferences(context)

            val data = p.getStringSet(ARTICLE_IDS_KEY, mutableSetOf())!!
            val tmps = mutableSetOf<String>().apply {
                this.addAll(data)
                this.add(articleId)
            }
            p.edit {
                putStringSet(ARTICLE_IDS_KEY, tmps)
            }
        }

        fun getArticleIds(context: Context): Set<String> {
            val p = PreferenceManager.getDefaultSharedPreferences(context)
            return p.getStringSet(ARTICLE_IDS_KEY, setOf()) ?: setOf()
        }
    }

}

private const val ARTICLE_IDS_KEY = "article_ids_key"