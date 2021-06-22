package com.equinoxlabs.demoassignmentapp.Data.repository

import com.equinoxlabs.demoassignmentapp.Data.Mapper.UserDataMapper
import com.equinoxlabs.demoassignmentapp.Data.services.RestApi
import com.equinoxlabs.demoassignmentapp.Domain.entity.DataResponseEntity
import com.equinoxlabs.demoassignmentapp.Domain.repository.UserRepository
import io.reactivex.Observable

class UserDataRepository constructor(var mRestApi: RestApi, var mUserDataMapper: UserDataMapper) :
    UserRepository {
    override fun getData(): Observable<DataResponseEntity> {
        return mRestApi.getData().map(mUserDataMapper::getData)

    }
}