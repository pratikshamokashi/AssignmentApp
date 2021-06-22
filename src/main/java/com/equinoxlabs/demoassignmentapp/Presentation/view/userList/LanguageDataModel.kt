package com.equinoxlabs.demoassignmentapp.Presentation.view.userList

import com.ecourier.courier.presentation.enums.Status
import com.equinoxlabs.demoassignmentapp.Domain.entity.DataResponseEntity
import com.google.gson.annotations.SerializedName

class DataResponseModel(
    status: Status,
    var mDataEntity: DataResponseEntity?,
    var error: Throwable?
    ) {


        @SerializedName("Success")
        var success: Boolean? = null
        @SerializedName("Message")
        var message: String? = null
        @SerializedName("Data")
        var data: List<DataResponseEntity>? = null

        var status: Status? = status

        companion object {

            fun success(response: DataResponseEntity): DataResponseModel {
                return DataResponseModel(Status.SUCCESS, response, null)
            }

            fun error(error: Throwable): DataResponseModel {
                return DataResponseModel(Status.ERROR, null, error)
            }
        }
    }