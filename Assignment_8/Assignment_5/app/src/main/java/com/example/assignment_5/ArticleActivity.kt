package com.example.assignment_5

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide

class ArticleActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val imageURL: String = intent.getStringExtra("imageURL")!!
        val articleImageView: ImageView = findViewById(R.id.article_iv)
        Glide.with(this)
            .load(imageURL)
            .into(articleImageView)
        val title: String = intent.getStringExtra("title")!!
        val articleTitleTextView: TextView = findViewById(R.id.article_title_tv)
        articleTitleTextView.text = title
        var content = intent.getStringExtra("content")!!
        val articleContentTextView: TextView = findViewById(R.id.article_content_tv)
        val articleURL: String = intent.getStringExtra("articleURL")!!
        val readMoreStr = "<a href='${articleURL}'> read full article </a>"
        println("readMoreStr: $readMoreStr")
        val readMoreSpannable = Html.fromHtml(readMoreStr, Html.FROM_HTML_MODE_COMPACT)
        content = content.replace(Regex("… \\[\\+.*]"), "... ")
        val spannableContent = SpannableStringBuilder(content).append(readMoreSpannable)
        articleContentTextView.text = spannableContent
        articleContentTextView.movementMethod = LinkMovementMethod.getInstance();
    }
}