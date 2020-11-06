package com.example.tictactoe_c_p_vm.Presenter;

/**
 * @author CFD_08
 */
public interface TicTacToeView {

    void showWinner(String winningPlayerDisplayLabel);
    void clearWinnerDisplay();
    void clearButtons();
    void setButtonText(int row, int col, String text);

}
