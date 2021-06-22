package com.go2future.tuvoclient.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.equinoxlabs.demoassignmentapp.Data.local.DataEntity
import com.equinoxlabs.demoassignmentapp.Domain.entity.DataE

@Database(entities = [(DataEntity::class)], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDataDao(): AppTextDao
}


