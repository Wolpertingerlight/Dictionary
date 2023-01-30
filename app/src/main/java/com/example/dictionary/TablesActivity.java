package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TablesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        Button btnNewTable = findViewById(R.id.btn_new_table);
        btnNewTable.setOnClickListener(this::onBtnNewTable);
    }

    private void onBtnNewTable(View view){
        Intent intent = new Intent(this, NewTableActivity.class);
        startActivity(intent);
        //return;
    }
}