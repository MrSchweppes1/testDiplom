package com.example.testdiplom

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SimpleCursorAdapter
import android.widget.Spinner

class AddEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)



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


}