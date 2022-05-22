package com.example.testdiplom.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import java.sql.SQLData

class MyDbManager(context: Context) {
    val myDbHelper= MyDbHelper(context)
    var db: SQLiteDatabase? = null


    fun openDb(){
        db = myDbHelper.writableDatabase
    }
    fun insertToDb( groupname: String, surename: String, name: String, patronymic:String){
        val values = ContentValues().apply{
            put(MyDbNameClass.MyDbGroups.Groups_GROUPNAME, groupname)
            put(MyDbNameClass.MyDbGroups.Groups_SURENAME, surename)
            put(MyDbNameClass.MyDbGroups.Groups_NAME, name)
            put(MyDbNameClass.MyDbGroups.Groups_PATRONYMIC, patronymic)
        }
        db?.insert(MyDbNameClass.MyDbGroups.TABLE_NAME,null,values)
    }

    @SuppressLint("Range")
    fun readDbData() : ArrayList<String>{
        val dataList = ArrayList<String>()

        val cursor = db?.query(MyDbNameClass.MyDbGroups.TABLE_NAME,null,null,
            null,null,null,null)


            while (cursor?.moveToNext()!!){
                val dataText = cursor.getString(cursor.getColumnIndex(MyDbNameClass.MyDbGroups.Groups_NAME))

                dataList.add(dataText.toString())
            }
        cursor.close()
        return dataList
    }

    fun closeDb(){
        myDbHelper.close()
    }
}