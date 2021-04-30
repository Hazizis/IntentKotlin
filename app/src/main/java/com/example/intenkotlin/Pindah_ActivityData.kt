package com.example.intenkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Pindah_ActivityData : AppCompatActivity() {
    companion object{
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_UMUR = "extra_umur"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_data)

        val tvDataTerima:TextView = findViewById(R.id.actData)
        val nama = intent.getStringExtra(EXTRA_NAMA)
        val umur = intent.getIntExtra(EXTRA_UMUR, 0)

        val text = "Nama = $nama, Umur = $umur"
        tvDataTerima.text = text

    }


}