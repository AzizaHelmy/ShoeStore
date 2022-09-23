package com.aziza.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aziza.shoestore.model.Shoe

class SharedViewModel : ViewModel() {
    private val _shoeListResult = MutableLiveData<List<Shoe>>()
    val shoeListResult: LiveData<List<Shoe>> = _shoeListResult
    private var shoeList = mutableListOf<Shoe>()

    fun addShoe(newShoe: Shoe) {
        newShoe.let { item ->
            shoeList.add(item)
            _shoeListResult.value = shoeList
        }
    }

    fun validateData(name: String, company: String, size: Int, description: String) {

    }
}