package tictactoe.jerryppo.com.tictaktoe_mvvm.viewmodel

import android.databinding.ObservableArrayMap
import android.databinding.ObservableField
import android.util.Log
import jeongtae.com.tictactoe.model.Board
import jeongtae.com.tictactoe.model.Player


class TicTacToeViewModel(val model: Board) : ViewModel {

    val cells: ObservableArrayMap<String, String> = ObservableArrayMap()
    val winner: ObservableField<String> = ObservableField()

    override fun onCreate() {
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }

    fun onClickedCellAt(row: Int, col: Int) {
        model.mark(row, col)
        cells.put("$row$col", model.currentTurn.name)
        model.flipCurrentTurn()

        Log.d("[TEST]" , model.state.name)
        if (model.state == Board.GameState.FINISHED) {
            winner.set("${model.winner.name} is winner" )
        }

    }

    fun onResetSelected() {
        model.restart()
        winner.set("")
        cells.clear()
    }

}