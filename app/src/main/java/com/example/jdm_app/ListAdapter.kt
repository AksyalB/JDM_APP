package com.example.jdm_app

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.jdm_app.databinding.ItemjdmBinding

class ListAdapter(private val listMobil: ArrayList<Mobil>): RecyclerView.Adapter<ListAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemjdmBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)

    }

    override fun getItemCount(): Int = listMobil.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama, preview, foto ) = listMobil[position]
        holder.binding.ivGambar.setImageResource(foto)
        holder.binding.tvNama.text = nama
        holder.binding.tvDesc.text = preview
        holder.itemView.setOnClickListener{
            val intentdetail = Intent(holder.itemView.context,detail_activity::class.java)
            intentdetail.putExtra("key_mobil", listMobil[holder.adapterPosition])
            holder.itemView.context.startActivity(intentdetail)
        }

    }

    class ListViewHolder(var binding: ItemjdmBinding) : RecyclerView.ViewHolder(binding.root) {

    }

}