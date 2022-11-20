package com.example.myapplication111122.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication111122.data.models.PhonesDto
import com.example.myapplication111122.data.api.ApiConfig
import com.example.myapplication111122.data.repozitory.PhonesRepository
import com.example.myapplication111122.utils.ResourceState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch


class PhonesViewModel : ViewModel() {

    val repository = PhonesRepository(ApiConfig.apiService())
    private val _phonesLiveData = MutableLiveData<ResourceState<PhonesDto>>()
    val phonesLiveData: LiveData<ResourceState<PhonesDto>>
        get() = _phonesLiveData

    private val exeptionHandler = CoroutineExceptionHandler { _, exeption ->
        _phonesLiveData.postValue(ResourceState.Error(exeption.message))
    }

    fun loadPhones() {
        _phonesLiveData.value = ResourceState.Loading()
        viewModelScope.launch {

            val data = repository.getPhonesDto()
            _phonesLiveData.value = ResourceState.Success(data)

        }
    }


}