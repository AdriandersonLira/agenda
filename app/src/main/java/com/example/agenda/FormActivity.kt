package com.example.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FormActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etYear: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnList: Button
    private lateinit var dao: PersonDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        this.etName = findViewById(R.id.etName)
        this.etYear = findViewById(R.id.etYear)
        this.btnAdd = findViewById(R.id.btnAdd)
        this.btnList = findViewById(R.id.btnList)

        this.btnAdd.setOnClickListener{ save() }
        this.btnList.setOnClickListener{ list() }
    }

    fun save() {
        val name = this.etName.text.toString()
        val year = this.etName.text.toString().toInt()

        val person = Person(dao.count()+1, name, year)
        this.dao.add(person)

        Toast.makeText(this, "Pessoa salva", Toast.LENGTH_SHORT).show()
        val intent = Intent()
        intent.putExtra("People", person)
        setResult(RESULT_OK, intent)
    }

    fun list() {
        finish()
    }
}