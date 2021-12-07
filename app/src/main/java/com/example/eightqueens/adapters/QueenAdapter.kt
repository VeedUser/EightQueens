package com.example.eightqueens.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eightqueens.R
import com.example.eightqueens.fragments.Queen


class QueenAdapter : RecyclerView.Adapter<QueenAdapter.ViewHolder>() {

    private val mQueenList: MutableList<Queen> = mutableListOf()

    fun setData(resultQueen: List<Queen>) {
        mQueenList.clear()
        mQueenList.addAll(resultQueen)
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            itemView = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.cell_queen, viewGroup, false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mQueenList[position])
    }

    override fun getItemCount(): Int {
        return mQueenList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtResult: TextView = itemView.findViewById(R.id.txtResult)


        fun bind(model: Queen) {
            txtResult.text = model.resultQueen

        }
    }


}
