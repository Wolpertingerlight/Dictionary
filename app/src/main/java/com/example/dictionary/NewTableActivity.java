package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.dictionary.database.DBHelper;
import com.example.dictionary.models.Table;
import com.example.dictionary.templates.TableTemplate;

public class NewTableActivity extends AppCompatActivity {

    com.example.dictionary.database.DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_table);

        Table table= new Table(getString(R.string.table_name_fill));
        Button btnAddNewRow = findViewById(R.id.btn_add_new_row);
        EditText editNewTableName = findViewById(R.id.new_table_name);
        EditText editNewWord = findViewById(R.id.new_word);
        EditText editNewTranslate = findViewById(R.id.new_translate);
        TextView editTableName = (TextView)findViewById(R.id.table_name);

        final TableLayout tableLayout = (TableLayout) findViewById(R.id.new_table_place);


        editNewTableName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                String tableName = editNewTableName.getText().toString();
                table.setTableName(tableName);
                editTableName.setText(tableName);
                db.execSQL("INSERT OR IGNORE INTO table_list(name_table)VALUES (" + table.getTableName() + ");");

            }
        });


        btnAddNewRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newWord = editNewWord.getText().toString();
                String newTranslate = editNewTranslate.getText().toString();

                table.addToFirstColumn(newWord);
                table.addToSecondColumn(newTranslate);


                db = dbHelper.open();

                db.execSQL("INSERT OR IGNORE INTO words VALUES (" + table.getTableName()+");");
                String normName = db.rawQuery("select * from " + dbHelper.TABLE_LIST, null).getString(0);

                TableTemplate.addRowToTable(tableLayout, NewTableActivity.this, table);
            }
        });

    }


}