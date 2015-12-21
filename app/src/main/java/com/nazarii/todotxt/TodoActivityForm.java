package com.nazarii.todotxt;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.nazarii.todotxt.database.DbHelper;

public class TodoActivityForm extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.db = new DbHelper(getApplicationContext()).getWritableDatabase();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_activity_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox status = (CheckBox) findViewById(R.id.status);
                EditText name = (EditText) findViewById(R.id.name);
                ContentValues values = new ContentValues();
                values.put("status", status.getText().toString());
                values.put("name", name.getText().toString());
                db.insert("todo_item", null, values);
                db.close();
                finish();
            }
        });
    }

}
