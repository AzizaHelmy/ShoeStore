package com.aziza.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aziza.shoestore.model.Shoe

class SharedViewModel : ViewModel() {
    private val _shoeListResult = MutableLiveData<List<Shoe>>()
    val shoeListResult: LiveData<List<Shoe>> = _shoeListResult


    fun addShoe(newShoe: Shoe) {
        _shoeListResult.value = mutableListOf()
        _shoeListResult.value = listOf(newShoe)
    }

    fun validateData(name: String, company: String, size: Double, description: String) {

    }
}