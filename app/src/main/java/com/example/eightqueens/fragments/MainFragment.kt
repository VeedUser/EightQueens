package com.example.eightqueens.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.eightqueens.R


class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.startButtonOne).setOnClickListener {
            findNavController().navigate(R.id.boardFragmentOne)

        }
        view.findViewById<TextView>(R.id.startButtonTwo).setOnClickListener {
            findNavController().navigate(R.id.boardFragmentTwo)

        }







    }
    }

