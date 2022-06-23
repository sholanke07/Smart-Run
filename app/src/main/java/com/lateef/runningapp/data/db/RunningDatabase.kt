package com.lateef.runningapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lateef.runningapp.model.Run

@Database(entities = [Run::class], version = 1)
@TypeConverters(Converters::class)
abstract class RunningDatabase: RoomDatabase() {

    abstract fun getRunDao(): RunDao
}