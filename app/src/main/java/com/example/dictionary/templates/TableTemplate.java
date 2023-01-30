package com.example.dictionary.templates;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.dictionary.models.Table;

import java.util.ArrayList;

public class TableTemplate {

    public static void addRowToTable(TableLayout tableLayout, Context context, Table table){

        final TextView wordTextView = new TextView(context);
        final TextView translateTextView = new TextView(context);

        TableRow tableRow = new TableRow(context);

        wordTextView.setText(table.getFirstColumn().get(table.getFirstColumn().size()-1));
        translateTextView.setText(table.getSecondColumn().get(table.getSecondColumn().size()-1));
        tableRow.addView(wordTextView, new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));
        tableRow.addView(translateTextView, new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f));

        tableLayout.addView(tableRow, table.getFirstColumn().size()-1);

    }
}
