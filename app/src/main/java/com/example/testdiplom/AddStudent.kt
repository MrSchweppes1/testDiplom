package com.example.testdiplom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.testdiplom.db.MyDbManager

class AddStudent : AppCompatActivity() {
    val myDbManager = MyDbManager(this)

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



    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
        val dataList = myDbManager.readDbData()

    }

    fun onClickSave(view: View) {

       // findViewById<TextView>(R.id.tvTest).text = ""
        try {
                myDbManager.insertToDb(findViewById<EditText>(R.id.groupname).text.toString(),
                    findViewById<EditText>(R.id.surename).text.toString(),
                    findViewById<EditText>(R.id.name).text.toString(),
                    findViewById<EditText>(R.id.patronymic).text.toString()) // почему то не видит едит текст
                val dataList = myDbManager.readDbData()

                Toast.makeText(this@AddStudent, "Запись успешно добавлена", Toast.LENGTH_SHORT).show()
            }
        catch (ex:Exception){
            Toast.makeText(this@AddStudent,ex.localizedMessage, Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroy(){
        super.onDestroy()
        myDbManager.closeDb()
    }
}