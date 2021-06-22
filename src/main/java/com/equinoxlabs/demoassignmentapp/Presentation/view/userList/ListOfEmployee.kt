package com.equinoxlabs.demoassignmentapp.Presentation.view.userList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope

import androidx.recyclerview.widget.LinearLayoutManager
import com.ecourier.courier.data.datasource.exceptions.NetworkUnavailableException
import com.ecourier.courier.presentation.enums.Status
import com.equinoxlabs.demoassignmentapp.Data.local.DataEntity
import com.equinoxlabs.demoassignmentapp.Domain.entity.DataE
import com.equinoxlabs.demoassignmentapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.android.synthetic.main.activity_list_of_employee.*
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ListOfEmployee : AppCompatActivity(), SearchView.OnQueryTextListener {

    val mDataViewModel: DataViewModel by viewModel()
    var mLists: ArrayList<DataE> = ArrayList()
    private var mAdapter: DataListAdapter? = null
    val keysList: ArrayList<DataE> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_employee)

        search_view.setOnQueryTextListener(this)

        callApi()
    }
    fun callApi(){
        mDataViewModel.getData()
            observeDataResponse()
    }

    private fun observeDataResponse() {
        mDataViewModel.getDataResponse().observe(this, Observer { response ->
            when (response.status) {
                Status.SUCCESS -> {
                    Log.d("Error1", "${response.mDataEntity?.code}")
                    mLists = response.mDataEntity?.data as ArrayList<DataE>
                    showData(mLists)


                    lifecycleScope.launch {
//                        response.mDataEntity?.data?.let {

//                        }
                        val insertJob = async {
                            mDataViewModel.insert(response.mDataEntity?.data as ArrayList<DataEntity>)
                        }.await()
                        insertJob.apply {
                            keysList.clear()
                            keysList.addAll(mLists)
                        }
                        Log.d("Error4","${keysList.size}")
                    }
                    }
                Status.ERROR -> {
                    Log.d("Error2",""+response.error)
                    if (response.error is NetworkUnavailableException){

                        showLocalData(keysList)
                    }
                }

            }
        })
    }

    private fun showLocalData(keysList: ArrayList<DataE>) {
        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.layoutManager = linearLayoutManager
        mAdapter = DataListAdapter(this,keysList)
        recycler_view.adapter = mAdapter
    }

    private fun showData(mLists: ArrayList<DataE>) {
        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            recycler_view.layoutManager = linearLayoutManager
        mAdapter = DataListAdapter(this,mLists)
        recycler_view.adapter = mAdapter
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        mAdapter!!.filter.filter(newText)
        return false
    }
}