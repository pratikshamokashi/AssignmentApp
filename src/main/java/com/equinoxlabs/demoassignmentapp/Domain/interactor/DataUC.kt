package com.equinoxlabs.demoassignmentapp.Domain.interactor

import com.equinoxlabs.demoassignmentapp.Domain.entity.DataResponseEntity
import com.equinoxlabs.demoassignmentapp.Domain.repository.UserRepository
import io.reactivex.Observable

class DataUC constructor(val userRepository: UserRepository) :
    UseCase<DataResponseEntity, Unit>() {
    override fun build(param: Unit): Observable<DataResponseEntity> {
        return userRepository.getData()
    }
}