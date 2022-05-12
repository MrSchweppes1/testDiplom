package com.example.testdiplom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.testdiplom.db.MyDbManager

class MainActivity : AppCompatActivity() {

    val myDbManager = MyDbManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
        val dataList = myDbManager.readDbData()

        for (item in dataList){
            findViewById<TextView>(R.id.tvTest).append(item)
            findViewById<TextView>(R.id.tvTest).append("\n")

        }
    }

    fun onClickSave(view: View) {

        findViewById<TextView>(R.id.tvTest).text = ""

        myDbManager.insertToDb(findViewById<EditText>(R.id.edTitle).text.toString()) // почему то не видит едит текст
       val dataList = myDbManager.readDbData()

        for (item in dataList){
            findViewById<TextView>(R.id.tvTest).append(item)
            findViewById<TextView>(R.id.tvTest).append("\n")

        }

    }

    override fun onDestroy(){
        super.onDestroy()
        myDbManager.closeDb()
    }
}