package com.example.mvvmtutorial.presentation.ui

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmtutorial.domain.useCases.GetTextUseCase
import com.example.mvvmtutorial.domain.useCases.SaveTextUseCase

class MainActivityViewModel(
    private val saveUseCase: SaveTextUseCase,
    private val getSavedTextUseCase: GetTextUseCase,
    val context: Context,
) : ViewModel() {

    private val _savedText: MutableLiveData<String> = MutableLiveData()
    val savedText: LiveData<String> get() = _savedText


    fun saveText(text: String) {
        if (text.trim().isEmpty()) {
            makeToast(NO_TEXT_ERROR_MESSAGE)
        } else {
            saveUseCase.saveText(text)
            _savedText.value = text
        }
    }

    fun getText() {
        val savedText = getSavedTextUseCase.getSavedText()
        if (savedText.trim().isEmpty()) {
            makeToast(STORAGE_EMPTY_TEXT)
        } else {
            _savedText.value = savedText
        }
    }

    private fun makeToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val NO_TEXT_ERROR_MESSAGE =
            "Нет ничего для сохранения!!! Убедитесь что вы заполнили строку!!!"
        private const val STORAGE_EMPTY_TEXT = "В хранилище отсутствуют текста для отображения!!!"
    }
}