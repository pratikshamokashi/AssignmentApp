package com.equinoxlabs.demoassignmentapp.Data.services

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.ecourier.courier.data.datasource.exceptions.NetworkUnavailableException
import com.equinoxlabs.demoassignmentapp.Data.Responses.DataResponse
import com.go2future.tuvoclient.ErrorResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import retrofit2.Response

class RestApiImpl constructor(
    var mNetworkService: NetworkServices,
    var mContext: Context
) : RestApi  {

    var context: Context

    val type = object : TypeToken<ErrorResponse>() {}.type
    val gson = Gson()

    init {
        this.context = mContext
    }


    override fun getData(): Observable<Response<DataResponse>> {
        return Observable.create<Response<DataResponse>> { emitter ->

            if (!isThereInternetConnection()) {
                emitter.onError(NetworkUnavailableException())
                return@create
            }
            val sessionEntity: Response<DataResponse> =
                mNetworkService.getData().execute()

            if (sessionEntity.isSuccessful) {
                if (sessionEntity.body() != null) {
                    emitter.onNext(sessionEntity)

                    emitter.onComplete()
                } else {
                    emitter.onError(UnknownError())
                }
            } else {
                val error = sessionEntity.errorBody()
                Log.e("Error", "" + error)
                val errorResponse: ErrorResponse? =
                    gson.fromJson(sessionEntity.errorBody()!!.charStream(), type)
            }
        }

    }


    fun isThereInternetConnection(): Boolean {
        val cm =
            this.mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetworkInfo != null
    }

}