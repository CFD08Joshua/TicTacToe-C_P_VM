package com.example.tictactoe_c_p_vm.Presenter;

import com.example.tictactoe_c_p_vm.CommonModel.Board;
import com.example.tictactoe_c_p_vm.CommonModel.Player;

public class TicTacToePresenter implements Presenter {

    private TicTacToeView view;
    private Board model;

    public TicTacToePresenter(TicTacToeView view) {
        this.view = view;
        this.model = new Board();
    }

    @Override
    public void onCreate() {
        model = new Board();
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

    //  O X 哪裡
    public void onButtonSelected(int row, int col) {
        Player playerThatMove = model.mark(row, col);

        if (playerThatMove != null) {
            view.setButtonText(row, col, playerThatMove.toString());

            if (model.getWinner() != null) {
                view.showWinner(playerThatMove.toString());
            }
        }
    }

    //  重來
    public void onResetSelected() {
        view.clearWinnerDisplay();
        model.restart();
        view.clearButtons();
    }
}
