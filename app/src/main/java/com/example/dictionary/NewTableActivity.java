package com.example.dictionary;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dictionary.models.Table;

public class NewTableActivity extends AppCompatActivity {

    com.example.dictionary.database.DBHelper dbHelper;
   // SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_table);

        Table table = new Table(getString(R.string.table_name_fill));

//        Button btnAddNewRow = findViewById(R.id.btn_add_new_row);
//        EditText editNewTableName = findViewById(R.id.new_table_name);
//        EditText editNewWord = findViewById(R.id.new_word);
//        EditText editNewTranslate = findViewById(R.id.new_translate);
//        TextView editTableName = (TextView)findViewById(R.id.table_name);
//
//        final TableLayout tableLayout = (TableLayout) findViewById(R.id.new_table_place);


//
//        editNewTableName.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
//            @Override
//            public void afterTextChanged(Editable editable) {
//                String tableName = editNewTableName.getText().toString();
//
////                table.setTableName(tableName);
////                editTableName.setText(tableName);
////                DBHelper db = new DBHelper( NewTableActivity.this);
////                db.addTable(table.getTableName());
//
//            }
//        });


//        btnAddNewRow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){

//                String newWord = editNewWord.getText().toString();
//                String newTranslate = editNewTranslate.getText().toString();
//
//                table.addToFirstColumn(newWord);
//                table.addToSecondColumn(newTranslate);
//
//
//
//                TableTemplate.addRowToTable(tableLayout, NewTableActivity.this, table);
//            }
//        });
//
//    }

    }
}