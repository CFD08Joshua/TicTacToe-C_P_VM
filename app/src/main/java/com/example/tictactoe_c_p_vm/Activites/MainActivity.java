package com.example.tictactoe_c_p_vm.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tictactoe_c_p_vm.R;

public class MainActivity extends AppCompatActivity {

    private Button btn_C,btn_P,btn_VM;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_C=(Button)findViewById(R.id.btn_C);
        btn_P=(Button)findViewById(R.id.btn_P);
        btn_VM=(Button)findViewById(R.id.btn_VM);
        btn_C.setOnClickListener(mOnClickListener);
        btn_P.setOnClickListener(mOnClickListener);
        btn_VM.setOnClickListener(mOnClickListener);
    }
    
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_C:
                    intent = new Intent(MainActivity.this, MVCActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_P:
                    intent = new Intent(MainActivity.this, MVPActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_VM:
                    intent = new Intent(MainActivity.this, MVVMActivity.class);
                    startActivity(intent);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }
        }
    };
}