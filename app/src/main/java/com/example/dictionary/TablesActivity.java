package com.example.dictionary;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.dictionary.fragments.TableListFragment;
import com.example.dictionary.models.Table;

public class TablesActivity extends AppCompatActivity {

    public static Table table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);


        //FrameLayout frameLayout = findViewById(R.id.fl_table_content);

        TableListFragment tableListFragment = new TableListFragment();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_table_content, tableListFragment);
        fragmentTransaction.commit();
    }



}