package com.example.lab1.model

import java.io.Serializable
import java.util.UUID

open class ParentPizza(
    open val id: String = UUID.randomUUID().toString(),
    open val name: String,
    open val shortdescription: String,
    open val price: Int,
    open val imageRes: Int):Serializable {
}