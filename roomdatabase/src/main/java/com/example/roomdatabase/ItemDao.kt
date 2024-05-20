package com.example.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ItemDao {

    @Query("SELECT * FROM item_database")
    fun getAllItems():MutableList<Item>

    @Query("SELECT * FROM item_database where line_1 LIKE:line1")
    fun getItemLikeLine1(line1:String):Item

    @Query("SELECT * FROM item_database where line_2 LIKE:line2")
    fun getItemLikeLine2(line2:String):Item

    @Insert
    fun saveObject(item:Item)

    @Update
    fun changeItem(item:Item)

    @Delete
    fun deleteObject(item: Item)

}