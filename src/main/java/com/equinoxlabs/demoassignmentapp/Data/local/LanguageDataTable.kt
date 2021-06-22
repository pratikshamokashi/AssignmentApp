package com.equinoxlabs.demoassignmentapp.Data.local

import android.os.Build.ID
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "DataTable")
data class DataEntity @JvmOverloads constructor(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "User Name")
    var name: String? = null,

    @ColumnInfo(name = "Dept Name")
    var deptName: String? = null


): Serializable