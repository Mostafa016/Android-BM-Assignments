package com.example.assignment6

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class CounterFragment: Fragment(R.layout.fragment_counter)
{
    private var count: Int = 0
    private lateinit var counter_tv: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counter_tv = view.findViewById(R.id.counter_tv)
    }

    fun addOne()
    {
        count++
        counter_tv.text = count.toString()
    }
}