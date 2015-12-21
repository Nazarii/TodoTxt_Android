package com.nazarii.todotxt.database;

import android.provider.BaseColumns;

/**
 * Created by nazik on 21.12.15.
 */
public class Contract {
    public static final class TodoItem implements BaseColumns {

        public static final String TABLE_NAME = "todo_item";

        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_NAME = "name";
    }
}

