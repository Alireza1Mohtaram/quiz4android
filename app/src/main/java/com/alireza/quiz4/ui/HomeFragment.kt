package com.alireza.quiz4.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alireza.quiz4.R
import com.alireza.quiz4.data.repository.UserRepository
import com.alireza.quiz4.databinding.HomeFragmentBinding

class HomeFragment : Fragment(R.layout.home_fragment) {

    val viewModel : UserViewModel by viewModels(factoryProducer = { CustomViewModelFactory() })
    var userAdapter = UserAdapter()
    lateinit var binding : HomeFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = HomeFragmentBinding.bind(view)

        initRecyclerView()

        viewModel.getAllUser(hashMapOf())
        viewModel.movieList.observe(viewLifecycleOwner){
            userAdapter.setData(it)
        }

        binding.addUser.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_addUserFragment)
        }

    }

    private fun initRecyclerView()
    {
        binding.listUser.adapter =userAdapter
        binding.listUser.layoutManager = LinearLayoutManager(requireContext())

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

            }
        }).attachToRecyclerView(binding.listUser)

    }

}