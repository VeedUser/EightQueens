package com.example.eightqueens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class MainFragment : Fragment(R.layout.fragment_main) {




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

