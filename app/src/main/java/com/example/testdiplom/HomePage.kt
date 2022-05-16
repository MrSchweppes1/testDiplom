package com.example.testdiplom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
    }

    fun onClickEvent(view: View){
        val intent = Intent(this@HomePage, AddEvent::class.java)
        startActivity(intent)
    }
    fun onClickNewEquip(view: View){
        val intent = Intent(this@HomePage, NewEquipment::class.java)
        startActivity(intent)
    }

    fun onClickChecklist(view: View){
        val intent = Intent(this@HomePage, ChecklistPage::class.java)
        startActivity(intent)
    }

    fun onClickStudent(view: View){
        val intent = Intent(this@HomePage, AddStudent::class.java)
        startActivity(intent)
    }
}