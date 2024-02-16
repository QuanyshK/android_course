package com.example.lab1.model

import android.os.Parcelable
import java.io.Serializable
import java.util.UUID

data class Pizza(
 val id: String = UUID.randomUUID().toString(),
 val name: String,
 val shortdescription: String,
 val price: Int,
 val imageRes: Int
):Serializable