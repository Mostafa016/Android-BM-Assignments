package com.example.assignment6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), IncrementerFragment.OnIncrementerListener {
    lateinit var counterFragment: CounterFragment
    lateinit var incrementerFragment: IncrementerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterFragment = CounterFragment()
        incrementerFragment = IncrementerFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fcv_counter, counterFragment)
            .commit()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fcv_incrementer, incrementerFragment)
            .commit()
    }

    override fun increment() {
        counterFragment.addOne()
    }
}