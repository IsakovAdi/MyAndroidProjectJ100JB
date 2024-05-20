package com.example.retrofittutorial.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittutorial.domain.cloud.useCases.GetAllPostsUseCase
import com.example.retrofittutorial.domain.cloud.useCases.GetCommentsPostByIdUseCase
import com.example.retrofittutorial.domain.cloud.useCases.GetPostByIdUseCase
import com.example.retrofittutorial.domain.cloud.useCases.GetSortedPostsUseCase
import com.example.retrofittutorial.domain.cloud.useCases.GetSortedPostsUseCaseImpl
import com.example.retrofittutorial.domain.model.PostData
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val postByIdUseCase: GetPostByIdUseCase,
    private val commentsPostByIdUseCase: GetCommentsPostByIdUseCase,
    private val getSortedPostsUseCaseImpl: GetSortedPostsUseCase,
) : ViewModel() {
    private val _postData: MutableLiveData<List<PostData>> = MutableLiveData()
    val posts: LiveData<List<PostData>> get() = _postData

    private val _post: MutableLiveData<PostData> = MutableLiveData()
    val post: LiveData<PostData> get() = _post

    fun getPosts() {
        viewModelScope.launch {
            _postData.value = getAllPostsUseCase.getPosts()
        }
    }

    fun getPostById(postId: Int) {
        viewModelScope.launch {
            _post.value = postByIdUseCase.getPostById(postId)
        }
    }

    fun getCommentsPostsList(postId: Int) {
        viewModelScope.launch {
            _postData.value = commentsPostByIdUseCase.getPosts(postId)
        }
    }

    fun getSortedPost(postId: Int, sortBy: String, order: String) {
        viewModelScope.launch {
            _postData.value = getSortedPostsUseCaseImpl.getPosts(postId, sortBy, order)
        }
    }
}