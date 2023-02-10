package com.example.dictionary.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dictionary.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TableListFragment extends Fragment {


    public TableListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_table_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //View view = inflater.inflate(R.layout.fragment_table_list, container, false);
        FloatingActionButton btnCreateNewTable = view.findViewById(R.id.fab_create_new_table);
        btnCreateNewTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CreateNewTableFragment createNewTableFragment = new CreateNewTableFragment();

                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fl_table_content, createNewTableFragment);
                fragmentTransaction.commit();

            }
        });

    }
}