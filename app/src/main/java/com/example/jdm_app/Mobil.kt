package com.example.jdm_app

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mobil(
    val nama: String,
    val preview: String,
    val foto: Int,
    val deskripsi: String

): Parcelable
