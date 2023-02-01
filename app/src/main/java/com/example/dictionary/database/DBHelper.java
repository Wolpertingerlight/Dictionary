package com.example.dictionary.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dictionaryDB";

    private static String DB_PATH = "com/example/dictionary/database/dictionaryDB.db";

    public static final String TABLE_LIST = "table_list"; // название таблицы в бд
    public static final String ID_TABLE = "id_table";
    public static final String NAME_TABLE = "name_table";

    public static final String WORDS_TABLE = "words"; // название таблицы в бд
    public static final String ID_WORD = "id_table";
    public static final String WORD = "word";
    public static final String TRANSLATE = "translate";


    private Context myContext;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.myContext=context;
        DB_PATH =context.getFilesDir().getPath() + DATABASE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public SQLiteDatabase open()throws SQLException {

        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }

}
