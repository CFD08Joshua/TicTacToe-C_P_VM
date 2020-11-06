package com.example.tictactoe_c_p_vm.Activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.tictactoe_c_p_vm.R;
import com.example.tictactoe_c_p_vm.databinding.ActivityMvvmBinding;
import com.example.tictactoe_c_p_vm.viewmodel.TicTacToeViewModel;

public class MVVMActivity extends AppCompatActivity {

    TicTacToeViewModel viewModel = new TicTacToeViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        binding.setViewModel(viewModel);
        viewModel.onCreate();
    }
    @Override
    protected void onPause() {
        super.onPause();
        viewModel.onPause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
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
                viewModel.onResetSelected();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}