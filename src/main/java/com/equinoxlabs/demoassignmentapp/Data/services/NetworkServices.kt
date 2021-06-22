package com.equinoxlabs.demoassignmentapp.Data.services

import com.equinoxlabs.demoassignmentapp.Data.Responses.DataResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkServices {
    @GET("getManager")
    fun getData(): Call<DataResponse>

}