package com.alireza.quiz4.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alireza.quiz4.R
import com.alireza.quiz4.data.model.UserReqBody
import com.alireza.quiz4.data.model.UserResponse
import com.alireza.quiz4.databinding.AdduserFragmentBinding

class AddUserFragment : Fragment(R.layout.adduser_fragment) {

    val viewModel: UserViewModel by viewModels(factoryProducer = { CustomViewModelFactory() })
    lateinit var binding: AdduserFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AdduserFragmentBinding.bind(view)
        binding.createUser.setOnClickListener {
            if (checkInputs())

                viewModel.createUser(
                    UserReqBody(
                        binding.homeName.text.toString(),
                        listOf("Movie", "Sport"),
                        binding.homeFamily.text.toString(),
                        binding.homeNationalCode.text.toString()
                    )
                )
        }

    }

    private fun checkInputs(): Boolean {
        return (binding.homeName.text.isNullOrBlank() &&
                binding.homeName.text.isNullOrBlank() &&
                binding.homeName.text.isNullOrBlank())
    }
}