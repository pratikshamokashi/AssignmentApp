package com.equinoxlabs.demoassignmentapp.Data.services

import com.equinoxlabs.demoassignmentapp.Data.Responses.DataResponse
import io.reactivex.Observable
import okhttp3.MultipartBody
import retrofit2.Response

interface RestApi {
    fun getData():Observable<Response<DataResponse>>

}