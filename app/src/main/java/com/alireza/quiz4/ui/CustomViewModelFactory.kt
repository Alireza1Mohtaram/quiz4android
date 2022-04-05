package com.alireza.quiz4.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alireza.quiz4.RemoteDataSource
import com.alireza.quiz4.data.network.RetrofitApiProvider
import com.alireza.quiz4.data.network.UserApi
import com.alireza.quiz4.data.repository.UserRepository

class CustomViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val userRepository = UserRepository(RemoteDataSource(RetrofitApiProvider.userApi))
        return UserViewModel(userRepository) as T
    }
}