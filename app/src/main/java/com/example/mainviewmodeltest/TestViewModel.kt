package com.example.mainviewmodeltest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel(private val initial : Int) : ViewModel() {
    var number : MutableLiveData<Int> = MutableLiveData(initial)

    fun add(int: Int) =number.value?.let{
        number.setValue(it+int)

    }

}