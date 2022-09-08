package com.example.assignment_5

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_5.adapters.ArticleAdapter
import com.example.assignment_5.adapters.FavoritesAdapter
import com.example.assignment_5.local.LocalDatabase
import com.example.assignment_5.models.Articles

class FavoritesActivity : AppCompatActivity() {
    private lateinit var adapter: FavoritesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val recyclerView: RecyclerView = findViewById(R.id.rv_items_favorite)
        val database = LocalDatabase.getInstance(this)
        val articleDao = database.articleDao()
        val articles = articleDao.getAll()
        adapter = FavoritesAdapter(ArrayList(articles.map { Articles(
            urlToImage = it.imageURL,
            title = it.title,
            content = it.content,
            url = it.articleURL,
        ) }))
        recyclerView.adapter = adapter
    }
}