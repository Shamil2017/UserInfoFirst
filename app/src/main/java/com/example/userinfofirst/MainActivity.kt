package com.example.userinfofirst

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.time.LocalDateTime
import java.time.Year


class MainActivity : AppCompatActivity() {
    lateinit var tvName: TextView
    lateinit var tvYear: TextView
    lateinit var etName: EditText
    lateinit var etYear: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvName = findViewById<TextView>(R.id.tvName)
        tvYear = findViewById<TextView>(R.id.tvYear)
        etName = findViewById<EditText>(R.id.etName)
        etYear = findViewById<EditText>(R.id.etYear)
    }

    fun btnInfo(view: android.view.View) {
        val stName = etName.getText().toString()
        val stYear = etYear.getText().toString()
        if (stName == "") return
        val myYear = Integer.parseInt(stYear)
        val yearInt = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime.now().year
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        if (myYear>yearInt) return
        val myAge = yearInt - myYear
        Toast.makeText(this,"Ваш возраст: " ,Toast.LENGTH_LONG).show()
        Toast.makeText(this,stName+", Ваш возраст: " +myAge+" лет",Toast.LENGTH_LONG).show()
    }
}