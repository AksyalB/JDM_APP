package com.example.jdm_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.jdm_app.databinding.ActivityAboutPenulisBinding

class about_penulis : AppCompatActivity() {

    private lateinit var binding: ActivityAboutPenulisBinding

    companion object{
        const val NAMA_PENULIS = "namapenulis"
        const val akun_bangkit = "akun"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutPenulisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.namaPenulis.text = intent.getStringExtra(NAMA_PENULIS)
        binding.email.text = intent.getStringExtra(akun_bangkit)
        binding.gambarPenulis.setImageResource(R.drawable.foto_aksyal)




    }
}