package com.example.agenda

import android.content.ContentValues
import android.content.Context

class PersonDAO(var context: Context) {
    var dataHelper: DataHelper;

    init {
        this.dataHelper = DataHelper(this.context);
    }

    fun add(person: Person) {
        val cv = ContentValues();

        cv.put("name", person.name);
        cv.put("year", person.year);

        this.dataHelper.writableDatabase.insert("person", null, cv);
    }

    fun get(): ArrayList<Person> {
        var list = arrayListOf<Person>()
        val columns = arrayOf("id", "name", "year");
        val cursor = this.dataHelper.readableDatabase.query(
            "person",
            columns,
            null,
            null,
            null,
            null,
            null
        );

        cursor.moveToFirst();

        for (i in 1..cursor.count){
            var id = cursor.getInt(columns.indexOf("id"));
            var name = cursor.getString(columns.indexOf("name"));
            var year = cursor.getInt(columns.indexOf("year"));

            list.add(Person(id, name, year));
            cursor.moveToNext()
        }


        return list;
    }

    fun getPersonById(id: Int) {

    }

    fun count(): Int {
        val columns = arrayOf("id", "name", "year");
        val cursor = this.dataHelper.readableDatabase.query(
            "person",
            columns,
            null,
            null,
            null,
            null,
            null
        );

        return cursor.count
    }

    fun del(id: Int) {

    }


}