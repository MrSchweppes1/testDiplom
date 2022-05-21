package com.example.testdiplom.db

import android.provider.BaseColumns

object MyDbNameClass{
    const val DATABASE_VERSION = 3
    const val DATABASE_NAME = "AccountingOfWorkshops.db"

    object MyDbGroups :BaseColumns{
    const val TABLE_NAME = "Groups"
    const val COLUMN_NAME_GROUPNAME = "groupname"
    const val COLUMN_NAME_SURENAME = "surename"
    const val COLUMN_NAME_NAME = "name"
    const val COLUMN_NAME_PATRONYMIC= "patronymic"

        const val Create_Table = "Create table if not exists $TABLE_NAME (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_GROUPNAME TEXT, " +
                " $COLUMN_NAME_SURENAME TEXT, $COLUMN_NAME_NAME TEXT, $COLUMN_NAME_PATRONYMIC TEXT)"
        const val Drop_Table = "DROP TABLE IF EXISTS $TABLE_NAME"
    }


    object MyDbEquipment :BaseColumns{
        const val TABLE_NAME = "TABLE_NAME_Equipment"
        const val COLUMN_NAME_TitleEquip = "title_equip"
        const val COLUMN_NAME_SUBTITLE = "subtitle"

        const val Create_Table = "Create table if not exists $TABLE_NAME (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_TitleEquip TEXT, " +
                " $COLUMN_NAME_SUBTITLE TEXT)"
        const val Drop_Table = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

    object MydbWorkshops :BaseColumns{
        const val TABLE_NAME = "Workshops"
        const val COLUMN_NAME_Title = "title"

        const val Create_Table = "Create table if not exists $TABLE_NAME (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NAME_Title TEXT)"
        const val Drop_Table = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

    object MydbEvent :BaseColumns{
        const val TABLE_NAME = "EventList"
        const val COLUMN_NAME_Workshops = "workshops"
        const val COLUMN_NAME_LessonType = "lessonType"
        const val COLUMN_NAME_Topic = "topic"
        const val COLUMN_NAME_Exercise = "exercise"
        const val COLUMN_NAME_Criteria = "criteria"
        const val COLUMN_NAME_GroupNameID = "groupnameID"
        const val COLUMN_NAME_Date = "date"

    }
}