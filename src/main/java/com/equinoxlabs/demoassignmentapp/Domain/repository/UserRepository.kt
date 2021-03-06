package com.equinoxlabs.demoassignmentapp.Domain.repository

import androidx.annotation.WorkerThread
import com.equinoxlabs.demoassignmentapp.Data.local.DataEntity
import com.equinoxlabs.demoassignmentapp.Domain.entity.DataE
import com.equinoxlabs.demoassignmentapp.Domain.entity.DataResponseEntity
import com.equinoxlabs.demoassignmentapp.Presentation.view.UserApplication
import io.reactivex.Observable

interface UserRepository {
    fun getData(): Observable<DataResponseEntity>

    @WorkerThread
    suspend fun insert(mdataList: List<DataEntity?>){
        val dataDao = UserApplication.database?.getDataDao()
        dataDao?.insertAllData(mdataList)
    }
}