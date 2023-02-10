package com.example.dictionary.fragments;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.dictionary.R;
import com.example.dictionary.TablesActivity;

public class EditTableFragment extends Fragment {


    private static String Title;


    public EditTableFragment(String Title) {
        this.Title = Title;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_edit_table, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnAddNewRow = view.findViewById(R.id.btn_add_new_row);
        EditText editNewWord = view.findViewById(R.id.new_word);
        EditText editNewTranslate = view.findViewById(R.id.new_translate);
        TextView editTableName = view.findViewById(R.id.table_name);

        final TableLayout tableLayout =  view.findViewById(R.id.new_table_place);

        editTableName.setText(Title);



        btnAddNewRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newWord = editNewWord.getText().toString();
                String newTranslate = editNewTranslate.getText().toString();

                TablesActivity.table.addToFirstColumn(newWord);
                TablesActivity.table.addToSecondColumn(newTranslate);


                TableRow tableRow= new TableRow(getActivity());
                TextView textView1 = new TextView(getActivity());
                TextView textView2 = new TextView(getActivity());

                textView1.setText(newWord);
                textView1.setPadding(5, 5, 5, 5);


                textView2.setText(newTranslate);
                textView2.setPadding(5, 5, 5, 5);
                textView2.setGravity(Gravity.RIGHT);

                //textView1.setTextColor(Color.BLACK);
                //textView1.setTextSize(20);
                //textView1.setPadding(5, 5, 5, 5);
                tableRow.addView(textView1);
                tableRow.addView(textView2);
                tableLayout.addView(tableRow);

            }
        });

//        EditText editText = view.findViewById(R.id.new_table_title);
//        Button btnCreateTable = view.findViewById(R.id.btn_create_table);
//        btnCreateTable.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String tableTitle = editText.getText().toString();
//                TablesActivity.table = new Table(tableTitle);
//
//                EditTableFragment editTableFragment = new EditTableFragment(TablesActivity.table.getTableName());
//
//                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.fl_table_content, editTableFragment);
//                fragmentTransaction.commit();
//
//            }
//        });

    }
}