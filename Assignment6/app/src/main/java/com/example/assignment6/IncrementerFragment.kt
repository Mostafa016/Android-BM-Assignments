package com.example.assignment6

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class IncrementerFragment : Fragment(R.layout.fragment_incrementer) {
    private var callback: OnIncrementerListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val incrementBtn = view.findViewById<Button>(R.id.increment_btn)
        incrementBtn?.setOnClickListener {
            callback?.increment()
        }
    }

    interface OnIncrementerListener {
        fun increment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as OnIncrementerListener
    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }
}