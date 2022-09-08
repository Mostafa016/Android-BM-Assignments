package com.example.assignment_5.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment_5.ArticleActivity
import com.example.assignment_5.R
import com.example.assignment_5.local.ArticleEntity
import com.example.assignment_5.local.LocalDatabase
import com.example.assignment_5.models.Articles

class ArticleAdapter(var articles: ArrayList<Articles>?) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView
        val addFavoritesButton: Button

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textView)
            imageView = view.findViewById(R.id.imageView)
            addFavoritesButton = view.findViewById(R.id.btn_add_to_favorites)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.items_rv_row, viewGroup, false)
        val viewHolder: ViewHolder = ViewHolder(view)
        viewHolder.addFavoritesButton.setOnClickListener {
            val database: LocalDatabase = LocalDatabase.getInstance(viewGroup.context)
            val articleDao = database.articleDao()
            val position = viewHolder.adapterPosition
            articleDao.insert(
                ArticleEntity(
                    imageURL = articles?.get(position)?.urlToImage,
                    title = articles?.get(position)?.title,
                    content = articles?.get(position)?.content,
                    articleURL = articles?.get(position)?.url!!,
                )
            )
            Toast.makeText(viewGroup.context, "Added to favorites!", Toast.LENGTH_SHORT).show()
            viewHolder.addFavoritesButton.text = "Added to favorites"
            viewHolder.addFavoritesButton.isEnabled = false
        }
        return viewHolder
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.itemView.setOnClickListener {
            val context = it.context
            val intent = Intent(context, ArticleActivity::class.java)
            intent.putExtra("imageURL", articles?.get(position)?.urlToImage)
            intent.putExtra("title", articles?.get(position)?.title)
            intent.putExtra("content", articles?.get(position)?.content)
            intent.putExtra("articleURL", articles?.get(position)?.url)
            context.startActivity(intent)
        }
        viewHolder.textView.text = articles?.get(position)?.title
        Glide.with(viewHolder.itemView)
            .load(articles?.get(position)?.urlToImage)
            .into(viewHolder.imageView)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = articles?.size ?: 0

}
