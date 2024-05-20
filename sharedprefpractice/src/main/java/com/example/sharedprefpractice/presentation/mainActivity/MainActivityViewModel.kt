package com.example.sharedprefpractice.presentation.mainActivity

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sharedprefpractice.data.RepositoryImpl
import com.example.sharedprefpractice.domain.model.Item
import com.example.sharedprefpractice.domain.useCases.GetDataUseCaseImpl
import com.example.sharedprefpractice.domain.useCases.SaveDataUseCaseImpl

class MainActivityViewModel(val context: Context) : ViewModel() {
    private val repository = RepositoryImpl(context)
    private val saveDataUseCase = SaveDataUseCaseImpl(repository)
    private val getDataUseCase = GetDataUseCaseImpl(repository)

    private val _items: MutableLiveData<MutableList<Item>> = MutableLiveData()
    val items: LiveData<MutableList<Item>> get() = _items

    fun getData() {
        _items.value = getDataUseCase.getData().toMutableList()
    }

    fun saveData() {
        saveDataUseCase.saveData(_items.value ?: emptyList())
    }

    fun createDate(line1: String, line2: String) {
        val newItem = Item(line1 = line1, line2 = line2)
        val newItems = _items.value
        newItems?.add(newItem)
        _items.value = newItems
    }

    fun removeItem(position: Int) {
        _items.value?.removeAt(position)
    }


}