package com.example.testdiplom

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import java.sql.SQLData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SimpleCursorAdapter
import android.widget.Spinner
import com.example.testdiplom.db.MyDbNameClass

class AddEvent : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    var db: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        var spinner = findViewById<Spinner>(R.id.groupName)

        spinner!!.setOnItemSelectedListener(this)
        val dataList = arrayOf(readDbData())
        val array_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataList)
        /* array_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

         spinner!!.setAdapter(array_adapter)*/



    }

    @SuppressLint("Range")
    fun readDbData() : ArrayList<String>{
        val dataList = ArrayList<String>()

        val cursor = db?.query(
            MyDbNameClass.MyDbGroups.TABLE_NAME,null,null,
            null,null,null,null)


        while (cursor?.moveToNext()!!){
            val dataText = cursor.getString(cursor.getColumnIndex(MyDbNameClass.MyDbGroups.Groups_NAME))

            dataList.add(dataText.toString())
        }
        cursor.close()
        return dataList
    }



    fun onClickBack(view: View){
        val intent = Intent(this@AddEvent, HomePage::class.java)
        startActivity(intent)
    }

    fun onClickChecklist(view: View){
        val intent = Intent(this@AddEvent, ChecklistPage::class.java)
        startActivity(intent)
    }

    fun onClickStudent(view: View){
        val intent = Intent(this@AddEvent, AddStudent::class.java)
        startActivity(intent)
    }

    fun onClickAddEquip(view: View){
        val intent = Intent(this@AddEvent, AddEquipment::class.java)
        startActivity(intent)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
       // TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
       //TODO("Not yet implemented")
    }
}