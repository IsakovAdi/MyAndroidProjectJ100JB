package com.example.sharedprefpractice.presentation.secondActivity

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sharedprefpractice.data.RepositoryImpl
import com.example.sharedprefpractice.domain.model.Item
import com.example.sharedprefpractice.domain.useCases.GetDataUseCaseImpl

class SecondViewModel(val context: Context) : ViewModel() {
    val repository = RepositoryImpl(context)
    val getDataUseCase = GetDataUseCaseImpl(repository)

    private val _items: MutableLiveData<List<Item>> = MutableLiveData()
    val items: LiveData<List<Item>> get() = _items

    fun getData() {
        _items.value = getDataUseCase.getData()
    }
}