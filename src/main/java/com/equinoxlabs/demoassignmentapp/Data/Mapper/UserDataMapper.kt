package com.equinoxlabs.demoassignmentapp.Data.Mapper

import com.equinoxlabs.demoassignmentapp.Data.Responses.DataResponse
import com.equinoxlabs.demoassignmentapp.Domain.entity.DataE
import com.equinoxlabs.demoassignmentapp.Domain.entity.DataResponseEntity
import retrofit2.Response
import java.util.ArrayList

class UserDataMapper {
    fun getData(mDataResponse: Response<DataResponse>):DataResponseEntity{
        val DataResponse : DataResponse? = mDataResponse.body()
        val mDataEntity = DataResponseEntity()

        val mdataEntity = DataResponse?.data
        val mLanguageEntityData = ArrayList<DataE>()

        for (i in 0..mdataEntity?.size!! - 1) {
            val mData = DataE()
            mData.name = mdataEntity.get(i).name
            mData.deptName = mdataEntity.get(i).deptName
            mData.userId = mdataEntity.get(i).userId

            mLanguageEntityData.add(mData)
        }

        mDataEntity.data = mLanguageEntityData
        mDataEntity.code =DataResponse.code
        return mDataEntity
    }

}