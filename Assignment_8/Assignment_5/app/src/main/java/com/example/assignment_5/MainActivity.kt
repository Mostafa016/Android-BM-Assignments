package com.example.assignment_5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_5.adapters.ArticleAdapter
import com.example.assignment_5.models.EverythingModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rv_items)
        adapter = ArticleAdapter(ArrayList())
        recyclerView.adapter = adapter
        setArticles()
        val favoritesBtn: Button = findViewById(R.id.btn_go_to_favorites)
        favoritesBtn.setOnClickListener {
            val intent = Intent(this, FavoritesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setArticles() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val newsApi: NewsApi = retrofit.create(NewsApi::class.java)

        newsApi.everything(apiKey = "2bfa612098734ad7b4a06c2a6f7b663d", q = "tesla")
            .enqueue(object : Callback<EverythingModel> {
                override fun onResponse(
                    call: Call<EverythingModel>,
                    response: Response<EverythingModel>
                ) {
                    if (!response.isSuccessful) {
                        Toast.makeText(
                            this@MainActivity,
                            response.message(),
                            Toast.LENGTH_SHORT
                        ).show()
                        return
                    }
                    adapter.articles = response.body()?.articles
                    adapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<EverythingModel>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }
            })
    }
}

interface NewsApi {
    @GET("v2/everything")
    fun everything(@Query("q") q: String?, @Query("apiKey") apiKey: String): Call<EverythingModel>
}