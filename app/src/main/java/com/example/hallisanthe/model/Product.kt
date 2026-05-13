package com.example.hallisanthe.model

import java.io.Serializable

data class Product(
    val name: String,
    val price: String,
    val image: Int,
    val description: String
) : Serializable