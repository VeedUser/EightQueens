package com.example.eightqueens.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.eightqueens.R


class MainFragment : Fragment(R.layout.fragment_main) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.startButtonOne).setOnClickListener {
            timeToShowBoard(size = 4)
        }
        view.findViewById<TextView>(R.id.startButton).setOnClickListener {
            timeToShowBoard(size = 6)
        }
        view.findViewById<TextView>(R.id.startButtonTwo).setOnClickListener {
            timeToShowBoard(size = 8)
        }

    }

    private fun timeToShowBoard(size: Int) {
        val action = MainFragmentDirections.actionMainFragmentToBoardFragment().setSizeBoard(size)
        findNavController().navigate(action)
    }
}
