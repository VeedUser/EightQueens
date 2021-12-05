package com.example.eightqueens.classes

import java.util.ArrayList

 class NQueenSolution {
     val resultQueen = result
    fun solveBoard(

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
            result.add(v)
            return
        }

        var safe = (all_rows_filled
                and (rowmask or ldmask or rdmask).inv())
        while (safe > 0) {

            val p = safe and -safe
            val col = (Math.log(p.toDouble()) / Math.log(2.0)).toInt()
            board[row][col] = 'Q'
            solveBoard(
                board, row + 1, rowmask or p,
                ldmask or p shl 1,
                rdmask or p shr 1
            )


            safe = safe and safe - 1


            board[row][col] = ' '
        }
    }

    fun printBoard(board: Array<CharArray>) {
        for (i in board.indices) {
            print("|")
            for (j in 0 until board[i].lastIndex) {
                print(board[i][j].toString() + "|")
            }
            println()
        }
    }

    companion object {
        var result: MutableList<List<Int>> = ArrayList()
        @JvmStatic
        fun main(args: Array<String>) {

            val n = 5

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
            val solution = NQueenSolution()

            // Function Call
            result.clear()
            solution.solveBoard(
                board, row, rowmask, ldmask,
                rdmask
            )
            println(result)
        }
    }
}


