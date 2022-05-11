package com.example.testdiplom.db

import android.provider.BaseColumns

object MyDbNameClass :BaseColumns{
    const val TABLE_NAME = "Groups"
    const val COLUMN_NAME_TITLE = "title_group"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "AccountingOfWorkshops.db"

    const val Create_Table = "Create table if not exists $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_TITLE TEXT)"
    const val Drop_Table = "DROP TABLE IF EXISTS $TABLE_NAME"
}