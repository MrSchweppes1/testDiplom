package com.example.testdiplom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AddStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
    }

    fun onClickChecklist(view: View){
        val intent = Intent(this@AddStudent, ChecklistPage::class.java)
        startActivity(intent)
    }

    fun onClickHomePage(view: View){
        val intent = Intent(this@AddStudent, HomePage::class.java)
        startActivity(intent)
    }
}