package com.example.dictionary.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.dictionary.R;
import com.example.dictionary.TablesActivity;
import com.example.dictionary.database.DBHelper;
import com.example.dictionary.models.Table;

;


public class CreateNewTableFragment extends Fragment {

    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.context = container.getContext();
        return inflater.inflate(R.layout.fragment_create_new_table, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editText = view.findViewById(R.id.new_table_title);
        Button btnCreateTable = view.findViewById(R.id.btn_create_table);


        btnCreateTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String tableTitle = editText.getText().toString().trim();

                if(tableTitle.equals("") || tableTitle.equals(null)){
                    Toast toast = Toast.makeText(context, "Введите название",Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    DBHelper db = new DBHelper(context);
                    if(!db.checkDoubles(tableTitle)){

                        TablesActivity.table = new Table(tableTitle);

                        db.addTable(TablesActivity.table.getTableName());

                        EditTableFragment editTableFragment = new EditTableFragment(TablesActivity.table.getTableName());
                        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fl_table_content, editTableFragment);
                        fragmentTransaction.commit();
                    }
                    else{
                        Toast toast = Toast.makeText(context, "Таблица с таким названием уже существует",Toast.LENGTH_LONG);
                        toast.show();
                    }


                }

                //SELECT * from users WHERE column LIKE 'pineapple%';
                //Toast toast = Toast.makeText(this, "Hello Android!",Toast.LENGTH_LONG);
                //toast.show();



                //EditTableFragment editTableFragment = new EditTableFragment(TablesActivity.table.getTableName());



            }
        });

    }
}