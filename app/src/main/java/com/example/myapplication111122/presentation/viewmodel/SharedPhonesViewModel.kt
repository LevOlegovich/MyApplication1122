package com.example.myapplication111122.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication111122.data.api.ApiConfig
import com.example.myapplication111122.data.models.FilterModel
import com.example.myapplication111122.data.models.PhonesDto
import com.example.myapplication111122.data.repozitory.PhonesRepository
import com.example.myapplication111122.utils.Constants
import com.example.myapplication111122.utils.ResourceState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch


class SharedPhonesViewModel : ViewModel() {

    val repository = PhonesRepository(ApiConfig.apiService())

    private var _filterLiveData = MutableLiveData<FilterModel>()
    val filterLiveData: LiveData<FilterModel>
        get() = _filterLiveData

    private var _phonesLiveData = MutableLiveData<ResourceState<PhonesDto>>()
    val phonesLiveData: LiveData<ResourceState<PhonesDto>>
        get() = _phonesLiveData


    private val exeptionHandler = CoroutineExceptionHandler { _, exeption ->
        _phonesLiveData.postValue(ResourceState.Error(exeption.message))
    }

    private var filterParameters = mapOf<String, List<String>>()

    init {
        loadPhones()
    }


    fun loadPhones() {
        _phonesLiveData.value = ResourceState.Loading()

        viewModelScope.launch(exeptionHandler) {
            val data = repository.getPhonesDto()
            _phonesLiveData.value = ResourceState.Success(data)
        }
    }

    fun filterBrand(phones: PhonesDto): PhonesDto {
        val brandFilter = filterLiveData.value?.brand
        val defaultBrandText = filterParameters[Constants.BRAND_KEY]?.get(0)
        return if (!brandFilter.equals(defaultBrandText)) {
            val newListHomeStoreHotSale = phones.homeStoreHotSale
            val newListBestSeller =
                phones.bestSeller?.filter {
                    brandFilter?.let { brand -> it.title?.contains(brand) } == true
                }

            Log.d("PhonesViewModel: ", newListBestSeller.toString())
            Log.d("PhonesViewModel: ", brandFilter.toString())
            PhonesDto(newListHomeStoreHotSale, newListBestSeller)
        } else {
            phones
        }
    }


    fun saveFilter(filterModel: FilterModel) {
        _filterLiveData.value = filterModel
        _phonesLiveData.value = phonesLiveData.value
    }


    fun setFilterParameters(parameters: Map<String, List<String>>) {
        //Добавление всех фильтров
        if (filterParameters.isEmpty()) {
            filterParameters = parameters
        }
    }


}