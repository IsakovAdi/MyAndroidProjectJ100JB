package com.example.musicshop

class Product(
    val userName: String,
    val productTitle: String,
    val price: Int,
    var count: Int,
    var totalPrice: Int = price * count,
):java.io.Serializable