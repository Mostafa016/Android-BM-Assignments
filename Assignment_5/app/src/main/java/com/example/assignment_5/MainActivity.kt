package com.example.assignment_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private fun generateItemsList(size: Int) =
        List<Item>(size) { index -> Item("Photo #$index", "https://picsum.photos/id/$index/50/50") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ItemAdapter(generateItemsList(30))
        val recyclerView: RecyclerView = findViewById(R.id.rv_items)
        recyclerView.adapter = adapter
    }
}