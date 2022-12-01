package com.example.myapplication111122.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication111122.data.models.FilterModel

class MainViewModel : ViewModel() {


    private var _filterLiveData = MutableLiveData<FilterModel>()
    val filterLiveData: LiveData<FilterModel>
        get() = _filterLiveData



}