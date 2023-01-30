package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNewTest = findViewById(R.id.btn_new_test);
        Button btnTables = findViewById(R.id.btn_tables);
        Button btnExitApp = findViewById(R.id.btn_exit_app);

        btnNewTest.setOnClickListener(this::onBtnNewTest);
        btnTables.setOnClickListener(this::onBtnTables);
        btnExitApp.setOnClickListener(this::onBtnExitApp);


    }

    private void onBtnNewTest(View view){
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);

    }

    private void onBtnTables(View view){
        Intent intent = new Intent(this, TablesActivity.class);
        startActivity(intent);
         return;
    }

    private  void onBtnExitApp(View view){
        System.exit(0);
    }

}