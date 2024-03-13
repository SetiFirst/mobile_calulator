package com.example.calculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a: EditText = findViewById(R.id.text1)
        val b: EditText = findViewById(R.id.text2)
        val c: TextView = findViewById(R.id.textView)

        val sumBut: Button = findViewById(R.id.sum)
        val subBut: Button = findViewById(R.id.subtract)
        val mulBut: Button = findViewById(R.id.multiply)
        val divBut: Button = findViewById(R.id.divide)
        var s1: String
        var s2: String

        a.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                try {
                    if (s.toString() != "" && s.toString()[s.toString().lastIndex].toString().toInt() !in 0..9) {
                        Toast.makeText(
                            this@MainActivity,
                            "Не все поля заполненны",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } catch(e: Exception) {
                    Toast.makeText(
                        this@MainActivity,
                        "Ошибка! Вы ввели букву",
                        Toast.LENGTH_LONG
                    ).show()

                    var ss = ""
                    var index = 0

                    for(u in s){
                        if (index != s.lastIndex) {
                            ss += s[index]
                            index++
                        }
                    }
                    a.setText(ss)
                    a.setSelection(a.length())
                }
            }
        })

        b.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                try {
                    if (s.toString() != "" && s.toString()[s.toString().lastIndex].toString().toInt() !in 0..9) {
                        Toast.makeText(
                            this@MainActivity,
                            "Не все поля заполненны",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } catch(e: Exception) {
                    Toast.makeText(
                        this@MainActivity,
                        "Ошибка! Вы ввели букву",
                        Toast.LENGTH_LONG
                    ).show()

                    var ss = ""
                    var index = 0

                    for(u in s){
                        if (index != s.lastIndex) {
                            ss += s[index]
                            index++
                        }
                    }
                    b.setText(ss)
                    b.setSelection(b.length())
                }
            }
        })

        sumBut.setOnClickListener {

            s1 = a.getText().toString()
            s2 = b.getText().toString()
            if(s1 != "" && s2 != "") {
                val res = s1.toInt() + s2.toInt()
                c.text = "Sum is ${res}"
            }
        }

        subBut.setOnClickListener {

            s1 = a.getText().toString()
            s2 = b.getText().toString()
            if(s1 != "" && s2 != "") {
                val res = s1.toInt() - s2.toInt()
                c.text = "Subtract is ${res}"
            }
        }

        mulBut.setOnClickListener {
            s1 = a.getText().toString()
            s2 = b.getText().toString()
            if(s1 != "" && s2 != "") {
                val res = s1.toInt() * s2.toInt()
                c.text = "Multiple is ${res}"
            }
        }

        divBut.setOnClickListener {

            s1 = a.getText().toString()
            s2 = b.getText().toString()
            if(s1 != "" && s2 != "") {
                val res = s1.toInt() / s2.toInt()
                c.text = "Divide is ${res}"
            }
        }
    }
}