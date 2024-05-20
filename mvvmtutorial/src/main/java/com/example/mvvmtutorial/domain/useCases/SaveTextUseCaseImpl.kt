package com.example.mvvmtutorial.domain.useCases

import com.example.mvvmtutorial.domain.repository.Repository

class SaveTextUseCaseImpl(private val repository: Repository) : SaveTextUseCase {
    override fun saveText(text: String) = repository.save(text = text)
}