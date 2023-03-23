package com.example.jdm_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jdm_app.databinding.ActivityDetailBinding

class MainActivity : AppCompatActivity() {

    private lateinit var rv_Jdm: RecyclerView
    private val list = ArrayList<Mobil>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_Jdm = findViewById(R.id.rvjdm)
        rv_Jdm.setHasFixedSize(true)

        list.addAll(getlistmobil())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_me, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.about -> {
                val intent = Intent(this@MainActivity, about_penulis::class.java)
                intent.putExtra(about_penulis.NAMA_PENULIS, "Muhammad Aksyal Bambang Suseno")
                intent.putExtra(about_penulis.akun_bangkit, "a309dsx1124@bangkit.academy")
                startActivity(intent)
                return true

            }
        }
        return super.onOptionsItemSelected(item)
    }
    private fun getlistmobil(): ArrayList<Mobil>{
        val dataNama = resources.getStringArray(R.array.data_mobil)
        val dataPreview = resources.getStringArray(R.array.isi_sementara)
        val dataFoto = resources.obtainTypedArray(R.array.foto_mobil)
        val dataDeskripsi = resources.getStringArray(R.array.deskrpsi)
        val listMobil = ArrayList<Mobil>()
        for(i in dataNama.indices) {
            val mobil = Mobil(dataNama[i], dataPreview[i], dataFoto.getResourceId(i,-1), dataDeskripsi[i])
            listMobil.add(mobil)
        }
        return listMobil
    }
    private fun showRecyclerList() {
        rv_Jdm.layoutManager = LinearLayoutManager(this)
        val listmobilAdapter = ListAdapter(list)
        rv_Jdm.adapter = listmobilAdapter

    }
}