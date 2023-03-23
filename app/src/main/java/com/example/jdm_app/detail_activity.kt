package com.example.jdm_app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.jdm_app.databinding.ActivityDetailBinding


class detail_activity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val data = if(Build.VERSION.SDK_INT>=33){
            intent.getParcelableExtra<Mobil>("key_mobil")!!
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Mobil>("key_mobil")!!
        }

        binding.judulMobil.text = data.nama
        binding.deskripsi.text = data.deskripsi
        binding.gambar1.setImageResource(data.foto)



    }
}