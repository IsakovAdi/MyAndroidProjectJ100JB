package com.example.mvvmtutorial.domain.useCases

import com.example.mvvmtutorial.domain.repository.Repository

class GetTextUseCaseImpl(private val repository: Repository) : GetTextUseCase {
    override fun getSavedText(): String = repository.getText()
}