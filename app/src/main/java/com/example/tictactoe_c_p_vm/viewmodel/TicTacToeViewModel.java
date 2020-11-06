package com.example.tictactoe_c_p_vm.viewmodel;

import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

import com.example.tictactoe_c_p_vm.CommonModel.Board;
import com.example.tictactoe_c_p_vm.CommonModel.Player;

import java.util.Map;

/**
 * @author CFD_08
 */
public class TicTacToeViewModel implements ViewModel {
    private Board model;

    public final ObservableArrayMap<String,String> cells = new ObservableArrayMap<>();
    public final ObservableField<String> winner = new ObservableField<>();

    public TicTacToeViewModel(){
        model = new Board();
    }
    @Override
    public void onCreate() {

    }
    @Override
    public void onPause() {

    }
    @Override
    public void onResume() {

    }
    @Override
    public void onDestroy() {

    }

    public void onCellClicked(int row, int col) {
        Player playerThatMoved = model.mark(row, col);
        //  O X 顯示
        cells.put("" + row + col, playerThatMoved == null ? null : playerThatMoved.toString());
        //  顯示贏家
        winner.set(model.getWinner() == null ? null : model.getWinner().toString());
    }
    //  重來
    public void onResetSelected() {
        winner.set(null);
        model.restart();
        cells.clear();
    }
}
