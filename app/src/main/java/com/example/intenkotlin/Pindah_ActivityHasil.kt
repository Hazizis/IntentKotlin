package com.example.intenkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class Pindah_ActivityHasil : AppCompatActivity(), View.OnClickListener{

    private lateinit var btnPilih : Button
    private lateinit var rdGroup: RadioGroup

    companion object{
        const val EXTRA_PILIH_NOMOR = "extra_pilih_nomor"
        const val EXTRA_KODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_hasil)

        btnPilih = findViewById(R.id.btnPilihData)
        rdGroup = findViewById(R.id.rgNmr)

        btnPilih.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnPilihData) {
            if (rdGroup.checkedRadioButtonId >0){
                var value =0
                when(rdGroup.checkedRadioButtonId){
                    R.id.rb20 -> value = 20
                    R.id.rb30 -> value = 30
                    R.id.rb40 -> value = 40
                    R.id.rb50 -> value = 50

                }
                val hasilIntent = Intent()
                hasilIntent.putExtra(EXTRA_PILIH_NOMOR, value)
                setResult(EXTRA_KODE, hasilIntent)
                finish()
            }
        }
    }
}