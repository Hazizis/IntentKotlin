package com.example.intenkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Pindah_Activity_Obj : AppCompatActivity() {

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_obj)

        val tvObject: TextView = findViewById(R.id.object_terima)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text =  "Nama = ${person.name.toString()}, \nEmail = ${person.email.toString()}, \nUmur = ${person.age.toString()}, \nCity = ${person.city.toString()}"
        tvObject.text = text
    }
}