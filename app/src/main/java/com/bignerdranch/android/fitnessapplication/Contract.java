package com.bignerdranch.android.fitnessapplication;

import android.provider.BaseColumns;

public final class Contract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private Contract() {}

    /* Inner class that defines the table contents */
    public static class Entry implements BaseColumns {
        public static final String TABLE_NAME = "Users";
        public static final String _ID = BaseColumns._ID;
        public static final String FIRSTNAME = "Firstname";
        public static final String LASTNAME = "Lastname";
        public static final String USERNAME = "Username";
        public static final String PASSWORD = "Password";

    }
}
