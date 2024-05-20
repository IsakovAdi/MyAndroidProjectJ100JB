package com.example.recyclerview

import java.io.Serializable

class Product(
    val title:String,
    val desc:String,
    val price:Int,
    val count:Int
): Serializable {

}