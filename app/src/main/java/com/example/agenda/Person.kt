package com.example.agenda

import java.io.Serializable

class Person(var id: Int, var name: String, var year: Int): Serializable {
    override fun toString(): String {
        return this.name
    }
}