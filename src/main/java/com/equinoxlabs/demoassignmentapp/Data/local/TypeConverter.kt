package com.equinoxlabs.demoassignmentapp.Data.local

import androidx.room.TypeConverter
import com.equinoxlabs.demoassignmentapp.Domain.entity.DataE
import java.io.Serializable

    class TypecccConverterClass {
        companion object {

            @TypeConverter
            @JvmStatic
            fun daysOfWeekToString(daysOfWeek: MutableList<DataE>?): String? =
                daysOfWeek?.map { it.userId }?.joinToString()

        }
    }
