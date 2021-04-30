package com.example.intenkotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvHasil: TextView

    companion object{
        private const val REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindahAct: Button = findViewById(R.id.pindah_act)
        btnPindahAct.setOnClickListener(this)
        val btnPindaActData: Button = findViewById(R.id.pindah_actData)
        btnPindaActData.setOnClickListener(this)
        val btnPindahObj: Button = findViewById(R.id.pindahactobj)
        btnPindahObj.setOnClickListener(this)
        val btnTlp:Button = findViewById(R.id.call)
        btnTlp.setOnClickListener(this)
        val btnPindahHasil: Button = findViewById(R.id.pindahActHasil)
        btnPindahHasil.setOnClickListener(this)

        tvHasil = findViewById(R.id.dataHasil)

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.pindah_act ->{
                val moveIntent = Intent (this, Pindah_Activity::class.java)
                startActivity(moveIntent)
            }
            R.id.pindah_actData ->{
                val PindaActData = Intent (this, Pindah_ActivityData::class.java)
                PindaActData.putExtra(Pindah_ActivityData.EXTRA_NAMA, "Hazizi S")
                PindaActData.putExtra(Pindah_ActivityData.EXTRA_UMUR, 20)
                startActivity(PindaActData)

            }
            R.id.pindahactobj ->{
                val person = Person(
                    "Subhan Hazizi",
                    20,
                    "subhanzizy46@gmail.com",
                    "Nusa Tenggara Barat"
                )

                val PindahActObj = Intent (this, Pindah_Activity_Obj::class.java)
                PindahActObj.putExtra(Pindah_Activity_Obj.EXTRA_PERSON, person)
                startActivity(PindahActObj)
            }
            R.id.call ->{
                val nomorTlp = "+6285237649556"
                val tlpNmr = Intent (Intent.ACTION_DIAL, Uri.parse("tel:$nomorTlp"))
                startActivity(tlpNmr)
            }
            R.id.pindahActHasil ->{
                var PindahActHasil = Intent(this, Pindah_ActivityHasil::class.java)
                startActivityForResult(PindahActHasil, REQUEST_CODE)

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE){
            if (resultCode == Pindah_ActivityHasil.EXTRA_KODE){
                val pilihNmr = data?.getIntExtra(Pindah_ActivityHasil.EXTRA_PILIH_NOMOR,0)
                tvHasil.text = "Hasil = $pilihNmr"

            }
        }
    }


}