package com.equinoxlabs.demoassignmentapp.Presentation.di

import android.content.Context
import com.equinoxlabs.demoassignmentapp.Data.Mapper.UserDataMapper
import com.equinoxlabs.demoassignmentapp.Data.repository.UserDataRepository
import com.equinoxlabs.demoassignmentapp.Data.services.NetworkServices
import com.equinoxlabs.demoassignmentapp.Data.services.RestApi
import com.equinoxlabs.demoassignmentapp.Data.services.RestApiImpl
import com.equinoxlabs.demoassignmentapp.Domain.interactor.DataUC
import com.equinoxlabs.demoassignmentapp.Domain.repository.UserRepository
import com.facebook.stetho.okhttp3.StethoInterceptor
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        createRetrofit(
            createOkHttpClient()
        )
    }
    single { createNetworkApi(get()) }
    single {
        createRestAPI(
            get(),
            get()
        )
    }
    single {
        createUserRepository(
            get(),
            get()
        )
    }
    single { createGetDataUseCase(get()) }

}


fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .baseUrl("http://karma.equinoxlab.com/betaDailyUpdateApi/Service1.svc/")
        .client(okHttpClient)
        .build()
}
fun createOkHttpClient(): OkHttpClient {

    val httpClient = OkHttpClient.Builder()

    httpClient.addInterceptor { chain ->
        val original = chain.request()
        val request = original.newBuilder()
            .build()

        chain.proceed(request)
    }
        .addNetworkInterceptor(StethoInterceptor())
        .retryOnConnectionFailure(true)
        .callTimeout(
            2, TimeUnit.MINUTES
        )
        .connectTimeout(3000, TimeUnit.SECONDS)
        .writeTimeout(4000, TimeUnit.SECONDS)
        .readTimeout(3000, TimeUnit.SECONDS)

    return httpClient.build()
}
fun createNetworkApi(retrofit: Retrofit): NetworkServices {
    return retrofit.create(NetworkServices::class.java)
}

fun createRestAPI(mNetworkService: NetworkServices, mContext: Context): RestApi {
    return RestApiImpl(
        mNetworkService,
        mContext
    )
}

fun createUserRepository(mRestApi: RestApi, mapper: UserDataMapper): UserRepository {
    return UserDataRepository(
        mRestApi,
        mapper
    )
}
fun createGetDataUseCase(
    mUserRepository: UserRepository
): DataUC {
    return DataUC(mUserRepository)
}
