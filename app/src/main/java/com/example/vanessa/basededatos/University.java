package com.example.vanessa.basededatos;

import android.provider.BaseColumns;

/**
 * Created by uta on 12/10/2015.
 */
public class University {
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String PRIMARY_KEY = " PRIMARY KEY";
    private static final String COMMA_SEP = ",";

    public static abstract class StudentEntry implements BaseColumns{
        public static final String TABLE_NAME = "student";
        public static final String COLUMN_NAME_ENTRY_ID = "studentId";
        public static final String COLUMN_NAME_FIRST_NAME = "firstName";
        public static final String COLUMN_NAME_LAST_NAME = "lastName";

        public static final String SQL_CREATE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_ENTRY_ID + INTEGER_TYPE + PRIMARY_KEY + COMMA_SEP +
                        COLUMN_NAME_FIRST_NAME + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_LAST_NAME + TEXT_TYPE +
                        " )";
    }

}
