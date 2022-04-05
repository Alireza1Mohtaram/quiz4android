package com.alireza.quiz4.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.alireza.quiz4.R
import com.alireza.quiz4.data.model.UserResponse
import com.alireza.quiz4.databinding.DetailFragmentBinding

class DetailFragment : Fragment(R.layout.detail_fragment) {


    var user :UserResponse?= null
    lateinit var binding : DetailFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailFragmentBinding.bind(view)
        getUserDetail()
        if (user != null){
            setData()
        }
    }

    private fun setData() {
        binding.userDetailTxt.text = "${user!!.firstName}  ${user!!.lastName} ${user!!.nationalCode} ${user!!._id}"
    }

    fun getUserDetail(){
       user = requireArguments().get("user") as UserResponse

    }
}