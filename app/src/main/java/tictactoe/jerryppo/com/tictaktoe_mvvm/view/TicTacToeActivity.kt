package tictactoe.jerryppo.com.tictaktoe_mvvm.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import jeongtae.com.tictactoe.model.Board
import tictactoe.jerryppo.com.tictaktoe_mvvm.R
import tictactoe.jerryppo.com.tictaktoe_mvvm.databinding.TictactoeBinding
import tictactoe.jerryppo.com.tictaktoe_mvvm.viewmodel.TicTacToeViewModel

class TicTacToeActivity : AppCompatActivity() {

    val ticTacToeViewModel : TicTacToeViewModel = TicTacToeViewModel(Board())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.tictactoe)
        val tictactoeBinding = DataBindingUtil.setContentView<TictactoeBinding>(this, R.layout.tictactoe)
        tictactoeBinding.viewModel = ticTacToeViewModel
        ticTacToeViewModel.onCreate()
    }

    override fun onPause() {
        super.onPause()
        ticTacToeViewModel.onPause()
    }

    override fun onResume() {
        super.onResume()
        ticTacToeViewModel.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        ticTacToeViewModel.onDestroy()
    }


}
