package com.example.eightqueens.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eightqueens.R
import com.example.eightqueens.adapters.QueenAdapter
import com.example.eightqueens.classes.Queen


class MainActivity : AppCompatActivity() {
    private val mAdapter = QueenAdapter()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }



    private fun setupAdapter() {
        val layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerResultList)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = mAdapter
        setupAdapter()






    }






}
