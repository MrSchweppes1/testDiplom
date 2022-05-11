package com.example.testdiplom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.testdiplom.db.MyDbManager

class MainActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickSave(view: View) {
        myDbManager.openDb()
        myDbManager.insertToDb(edTitle.text.ToString()) // почему то не видит едит текст
    }

    override fun onDestroy(){
        super.onDestroy()
        myDbManager.closeDb()
    }
}