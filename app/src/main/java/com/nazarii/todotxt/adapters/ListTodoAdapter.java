package com.nazarii.todotxt.adapters;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.nazarii.todotxt.R;
import com.nazarii.todotxt.database.Contract;
import com.nazarii.todotxt.database.DbHelper;
import com.nazarii.todotxt.util.ValueHelper;

/**
 * Created by nazik on 21.12.15.
 */
public class ListTodoAdapter extends CursorAdapter {
    private final LayoutInflater mInflater;

    public ListTodoAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return mInflater.inflate(R.layout.list_todoitem, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        String status = cursor.getString(cursor.getColumnIndex(Contract.TodoItem.COLUMN_STATUS));
        String name = cursor.getString(cursor.getColumnIndex(Contract.TodoItem.COLUMN_NAME));

        TextView statusEl = (TextView) view.findViewById(R.id.checked);
        TextView nameEl = (TextView) view.findViewById(R.id.desc);

        statusEl.setText(status);
        nameEl.setText(name);
    }

    public static Cursor createFilteredCursor(Context context) {

        String[] columns = new String[]{
                Contract.TodoItem._ID,
                Contract.TodoItem.COLUMN_STATUS,
                Contract.TodoItem.COLUMN_NAME
        };

        String sql = "SELECT "+ ValueHelper.join(columns, ", ")+
                " FROM "+ Contract.TodoItem.TABLE_NAME +
                " ORDER BY "+ Contract.TodoItem.COLUMN_STATUS+" DESC";

        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();

        return db.rawQuery(sql, null);
    }
}
