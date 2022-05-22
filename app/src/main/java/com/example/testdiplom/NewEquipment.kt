package com.example.testdiplom

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.testdiplom.db.MyDbHelper
import com.example.testdiplom.db.MyDbManager
import com.example.testdiplom.db.MyDbNameClass
import android.content.Context
import android.widget.TextView

class NewEquipment : AppCompatActivity() {
    val myDbManager = MyDbManager(this)
    var db: SQLiteDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_equipment)
    }

    fun onClickBack(view: View){
        val intent = Intent(this@NewEquipment, HomePage::class.java)
        startActivity(intent)
    }

    fun onClickChecklist(view: View){
        val intent = Intent(this@NewEquipment, ChecklistPage::class.java)
        startActivity(intent)
    }

    fun onClickStudent(view: View){
        val intent = Intent(this@NewEquipment, ChecklistPage::class.java)
        startActivity(intent)
    }

    fun insertToDb( NameEquip: String, TypeEquip: String){
        val values = ContentValues().apply{
            put(MyDbNameClass.MyDbEquipment.Equipment_TitleEquip, NameEquip)
            put(MyDbNameClass.MyDbEquipment.Equipment_SUBTITLE, TypeEquip)
        }
        db?.insert(MyDbNameClass.MyDbEquipment.TABLE_NAME,null,values)
    }

    @SuppressLint("Range")
    fun readDbData() : ArrayList<String>{
        val dataList = ArrayList<String>()

        val cursor = db?.query(MyDbNameClass.MyDbEquipment.TABLE_NAME,null,null,
            null,null,null,null)


        while (cursor?.moveToNext()!!){
            val dataText = cursor.getString(cursor.getColumnIndex(MyDbNameClass.MyDbEquipment.Equipment_TitleEquip))

            dataList.add(dataText.toString())
        }
        cursor.close()
        return dataList
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
        val dataList = readDbData()
        for (item in dataList){
            findViewById<TextView>(R.id.tvTest).append(item)
            findViewById<TextView>(R.id.tvTest).append("\n")

        }
    }
    fun SaveEquip(view: View) {
        findViewById<TextView>(R.id.tvTest).text = ""

        try {
            insertToDb(findViewById<EditText>(R.id.NameEquip).text.toString(),
                findViewById<EditText>(R.id.TypeEquip).text.toString())


            val toast = Toast.makeText(this@NewEquipment, "Запись успешно добавлена", Toast.LENGTH_SHORT)
            toast.show()
        }
        catch (ex: Exception){
            val toast = Toast.makeText(this@NewEquipment,ex.localizedMessage, Toast.LENGTH_SHORT)
            toast.show()
        }
    }






}