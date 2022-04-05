package com.alireza.quiz4.ui

import androidx.lifecycle.*
import com.alireza.quiz4.data.model.UserReqBody
import com.alireza.quiz4.data.repository.UserRepository
import com.alireza.quiz4.data.model.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    val movieList = MutableLiveData<List<UserResponse>>()
    val userCreated = MutableLiveData<String>()
    fun getAllUser(query: HashMap<String, String>){

        viewModelScope.launch {
            val response = userRepository.getUserList(query)
            withContext(Dispatchers.Main) {
                    movieList.postValue(response.body())
                }
            }

    }
      fun createUser(user:UserReqBody){
          viewModelScope.launch {
              val response = userRepository.createUser(user)
              withContext(Dispatchers.Main) {
                  userCreated.postValue(response.body())
              }

      }
    }

}





