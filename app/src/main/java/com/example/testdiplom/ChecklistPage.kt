package com.example.testdiplom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ChecklistPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checklist_page)
    }

    fun onClickStudent(view: View){
        val intent = Intent(this@ChecklistPage, AddStudent::class.java)
        startActivity(intent)
    }

    fun onClickHomePage(view: View){
        val intent = Intent(this@ChecklistPage, HomePage::class.java)
        startActivity(intent)
    }
}