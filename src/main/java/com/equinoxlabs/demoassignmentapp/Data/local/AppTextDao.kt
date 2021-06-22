package com.go2future.tuvoclient.data.local


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.equinoxlabs.demoassignmentapp.Data.local.DataEntity
import com.equinoxlabs.demoassignmentapp.Domain.entity.DataE


@Dao
interface AppTextDao {

    @Query("SELECT * FROM DataTable")
    fun getAllAppText(): LiveData<List<DataEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAppText(dataList: List<DataEntity?>)

    @Query("DELETE FROM DataTable")
    fun deleteAllAppText()
}