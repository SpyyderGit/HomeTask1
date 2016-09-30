package com.example.superuser.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.superuser.myapplication.Config;
import com.example.superuser.myapplication.R;

/**
 * Created by SuperUser on 13.09.2016.
 */
public class SecondActivity extends AppCompatActivity {

    TextView secondTextView;
    Button mBtnBack;
    Button mBtnAddData;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        secondTextView = (TextView) findViewById(R.id.txt_second_activity);
        secondTextView.setText("Pam-paRam");
        mBtnBack = (Button) findViewById(R.id.btn_followSecond_activity);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        editText = (EditText) findViewById(R.id.edit_txt_edit);

        mBtnAddData = (Button) findViewById(R.id.btn_addData);
        mBtnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", editText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        Log.d(Config.TAG, "SecondActivity - onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Config.TAG, "SecondActivity - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Config.TAG, "SecondActivity - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Config.TAG, "SecondActivity - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Config.TAG, "SecondActivity - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Config.TAG, "SecondActivity - onDestroy");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}