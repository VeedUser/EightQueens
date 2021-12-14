package com.example.eightqueens.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eightqueens.R
import com.example.eightqueens.adapters.QueenAdapter


class BoardFragment : Fragment() {

    // Переменная для изьятия аргумента
    val args: BoardFragmentArgs by navArgs()

    private var mAdapter: QueenAdapter? = null

    var resultD: MutableList<List<Int>> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_board_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        // Берем с перемнной аргумент
        makeResult(args.sizeBoard)
    }

    private fun setupAdapter() {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        if (mAdapter == null) mAdapter = QueenAdapter()
        val recyclerView: RecyclerView? = view?.findViewById(R.id.recyclerResultList)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = mAdapter
    }

    private fun makeResult(sizeBoard: Int) {
        val n = sizeBoard

        val board = Array(n) {
            CharArray(
                n
            )
        }
        for (i in 0 until n) {
            for (j in 0 until n) {
                board[i][j] = ' '
            }
        }
        val rowmask = 0
        val ldmask = 0
        val rdmask = 0
        val row = 0

        solveBoardHere(
            board, row, rowmask, ldmask,
            rdmask
        )

        mAdapter?.setData(resultD.map { Queen(resultQueen = it.toString()) })
    }

    private fun solveBoardHere(
        board: Array<CharArray>, row: Int,
        rowmask: Int, ldmask: Int,
        rdmask: Int
    ) {
        val n = board.size

        val all_rows_filled = (1 shl n) - 1

        if (rowmask == all_rows_filled) {
            val v: MutableList<Int> = ArrayList()
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (board[i][j] == 'Q') v.add(j + 1)
                }
            }
            resultD.add(v)
            return
        }

        var safe = (all_rows_filled
                and (rowmask or ldmask or rdmask).inv())
        while (safe > 0) {

            val p = safe and -safe
            val col = (Math.log(p.toDouble()) / Math.log(2.0)).toInt()
            board[row][col] = 'Q'
            solveBoardHere(
                board, row + 1, rowmask or p,
                ldmask or p shl 1,
                rdmask or p shr 1
            )


            safe = safe and safe - 1


            board[row][col] = ' '
        }
    }
}

data class Queen(
    val resultQueen: String


)





