package com.example.eightqueens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class QueenAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TextViewHolder(itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_board_one,parent,false))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TextViewHolder -> holder.bind()
        }

    }

    override fun getItemCount(): Int {
        return 0

    }
    class TextViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(){

        }

    }
}