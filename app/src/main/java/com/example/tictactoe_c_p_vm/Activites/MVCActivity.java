package com.example.tictactoe_c_p_vm.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tictactoe_c_p_vm.CommonModel.Board;
import com.example.tictactoe_c_p_vm.CommonModel.Player;
import com.example.tictactoe_c_p_vm.R;

public class MVCActivity extends AppCompatActivity {

    private static String TAG = MVCActivity.class.getName();

    private Board model;

    private ViewGroup buttonGrid;
    private View winnerPlayerViewGroup;
    private TextView winnerPlayerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);

        winnerPlayerLabel = findViewById(R.id.winnerPlayerLabel);
        winnerPlayerViewGroup = findViewById(R.id.winnerPlayerViewGroup);
        buttonGrid = findViewById(R.id.buttonGrid);
        model = new Board();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tictactoe, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_reset:
                onResetSelected();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onCellClicked(View v) {

        Button button = (Button) v;

        String tag = button.getTag().toString();
        int row = Integer.valueOf(tag.substring(0, 1));
        int col = Integer.valueOf(tag.substring(1, 2));
        Log.i(TAG, "Click Row: [" + row + "," + col + "]");

        onButtonSelected(button,row,col);

    }
    //  O X 哪裡
    public void onButtonSelected(Button button ,int row,int col){
        Player playerThatMove = model.mark(row,col);
        if (playerThatMove != null) {
            setButtonText(button,playerThatMove.toString());
            if (model.getWinner() != null) {
                showWinner(playerThatMove);
            }
        }
    }
    //  重來
    private void onResetSelected() {
        clearWinnerDisplay();
        model.restart();
        clearButtons();
    }
    //  顯示贏家
    public void showWinner(Player playerThatMoved) {
        winnerPlayerLabel.setText(playerThatMoved.toString());
        winnerPlayerViewGroup.setVisibility(View.VISIBLE);
    }
    // 清除顯示贏家
    public void clearWinnerDisplay() {
        winnerPlayerViewGroup.setVisibility(View.GONE);
        winnerPlayerLabel.setText("");
    }
    // 清除O X 顯示
    public void clearButtons() {
        for( int i = 0; i < buttonGrid.getChildCount(); i++ ) {
            ((Button) buttonGrid.getChildAt(i)).setText("");
        }
    }
    // O X 顯示
    public void setButtonText(Button button, String text) {
        if(button != null) {
            button.setText(text);
        }
    }
}