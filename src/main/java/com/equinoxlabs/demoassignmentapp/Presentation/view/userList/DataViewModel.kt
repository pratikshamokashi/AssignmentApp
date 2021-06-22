package com.equinoxlabs.demoassignmentapp.Presentation.view.userList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.equinoxlabs.demoassignmentapp.Data.local.DataEntity
import com.equinoxlabs.demoassignmentapp.Domain.entity.DataE
import com.equinoxlabs.demoassignmentapp.Domain.entity.DataResponseEntity
import com.equinoxlabs.demoassignmentapp.Domain.interactor.DataUC
import com.equinoxlabs.demoassignmentapp.Presentation.view.UserApplication
import io.reactivex.observers.DisposableObserver
import kotlinx.coroutines.launch

class DataViewModel(var mDataUC: DataUC) :ViewModel() {
    var mMutableLiveDataModel = MutableLiveData<DataResponseModel>()

    fun getDataResponse(): LiveData<DataResponseModel> {
        return mMutableLiveDataModel
    }

//    fun getAppTextFromDb(): LiveData<List<DataE>> {
//        return UserApplication.database!!.getDataDao().getAllData()
//
//    }
suspend fun insert(mLanguageList:List<DataEntity?>) = viewModelScope.launch {
    mDataUC.userRepository.insert(mLanguageList)
}
    fun getData() {
        mDataUC.execute(object : DisposableObserver<DataResponseEntity>() {
            override fun onComplete() {
                Log.d("TAG--> ", "onComplete")

            }

            override fun onNext(response: DataResponseEntity) {
                mMutableLiveDataModel.value = DataResponseModel.success(response)
            }

            override fun onError(e: Throwable) {
                Log.d("TAG--> ", "onError" + e.message)
                mMutableLiveDataModel.value = DataResponseModel.error(e)
            }


        }, Unit)
    }
}