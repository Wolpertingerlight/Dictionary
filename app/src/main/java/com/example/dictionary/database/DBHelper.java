package com.example.dictionary.database;


import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dictionaryDB.db";

    private static String DB_PATH = "/data/data/com.example.dictionary/databases/dictionaryDB.db";

    public static final String TABLE_LIST = "table_list"; // название таблицы в бд
    public static final String ID_TABLE = "id_table";
    public static final String NAME_TABLE = "name_table";

    public static final String WORDS_TABLE = "words"; // название таблицы в бд
    public static final String ID_WORD = "id_word";
    public static final String WORD = "word";
    public static final String TRANSLATE = "translate";


    private Context context;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        //DB_PATH = context.getFilesDir().getPath() + DATABASE_NAME;
        //DB_PATH = DATABASE_NAME;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i(TAG, "--- onCreate Activity --- START");
        String query = " CREATE TABLE table_list ( id_table INTEGER PRIMARY KEY AUTOINCREMENT, name_table TEXT);";// +
               // "CREATE TABLE \"words\" ( \"id_word\" INTEGER NOT NULL UNIQUE, name_table TEXT, word TEXT, translate TEXT, PRIMARY KEY(id_word AUTOINCREMENT) )";

        sqLiteDatabase.execSQL(query);
        Log.i(TAG, "--- onCreate Activity --- DONE");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addTable(String tableTitle){
        // SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db = this.getWritableDatabase();; //= open();

        ContentValues cv = new ContentValues();
        cv.put(NAME_TABLE, tableTitle);
        Log.i(TAG, "--- Title of table add succesfully --- DONE");
        long result = db.insert(TABLE_LIST, null, cv);

        if(result == -1)
            Toast.makeText(context, "Add to \" Table list\" FAILED", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, "Название изменено", Toast.LENGTH_SHORT).show();

    }

    public void addWord(){

    }

    public boolean checkDoubles(String str){
        SQLiteDatabase db = this.getReadableDatabase();
        try{

           String query = "SELECT * from table_list WHERE name_table LIKE \"" + str + "\";";


            Cursor cursor = db.rawQuery(query, null);
            int count = cursor.getCount();

            //String mess = "--- There is count of string-----: " + Integer.toString(count) ;
            //Log.i(TAG, mess);

            return (count > 0) ? true : false;

        }catch (CursorIndexOutOfBoundsException e ){

            return false;

        }
    }


    public SQLiteDatabase open() throws SQLException {
        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READONLY);
    }

}
