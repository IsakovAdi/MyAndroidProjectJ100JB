package com.example.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_database")
class Item(
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    @ColumnInfo(name = "line_1") var line1:String,
    @ColumnInfo(name = "line_2")var line2:String
)