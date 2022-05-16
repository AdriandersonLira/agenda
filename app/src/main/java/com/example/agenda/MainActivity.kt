package com.example.agenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var buttonAdd: FloatingActionButton
    private lateinit var list: ListView
    private lateinit var listPeople: ArrayList<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.buttonAdd = findViewById(R.id.fabMainAdd)
        this.list = findViewById(R.id.lvMainPeople)
        this.listPeople = arrayListOf()

        this.list.adapter = ArrayAdapter<Person>(this, android.R.layout.simple_expandable_list_item_1, this.listPeople)


        val formResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val people = it.data?.getSerializableExtra("People") as Person
                Log.i("app_save_peopleeeeeee:","${people}")
                this.listPeople.add(people)
                (this.list.adapter as ArrayAdapter<Person>).add(people)
            }

//            if (it.resultCode == RESULT_CANCELED) {
//                this.list.adapter = ArrayAdapter<Person>(this, android.R.layout.simple_expandable_list_item_1, this.listPeople)
//            }
        }

        this.buttonAdd.setOnClickListener{
            val intent = Intent(this, FormActivity::class.java)

            formResult.launch(intent)
        }
    }
}