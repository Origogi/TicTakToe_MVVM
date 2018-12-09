package tictactoe.jerryppo.com.tictaktoe_mvvm.viewmodel

import android.databinding.ObservableArrayMap
import android.databinding.ObservableField
import android.util.Log
import jeongtae.com.tictactoe.model.Board
import jeongtae.com.tictactoe.model.Player


class TicTacToeViewModel(val model: Board) : ViewModel {

    val cells: ObservableArrayMap<String, String> = ObservableArrayMap()
    val winner: ObservableField<String> = ObservableField()

    init {
        winner.set("")
    }

    override fun onCreate() {
    }

    override fun onPause() {
    }

    override fun onResume() {
    }

    override fun onDestroy() {
    }

    fun onClickedCellAt(row: Int, col: Int) {
        if(!model.isValid(row, col)) {
            Log.d("[TEST]", "$row $col")
            return
        }
        model.mark(row, col)
        cells.put("$row$col", model.currentTurn.name)
        model.flipCurrentTurn()

        if (model.state == Board.GameState.FINISHED) {
            winner.set("${model.winner.name} is winner" )
        }

        winner.get().isNullOrEmpty()
    }

    fun onResetSelected() {
        model.restart()
        winner.set("")
        cells.clear()
    }

}