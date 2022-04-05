package com.alireza.quiz4.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alireza.quiz4.R
import com.alireza.quiz4.data.model.UserResponse

class UserAdapter() : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    var dataList = mutableListOf<UserResponse>()

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtUserShow: TextView = itemView.findViewById(R.id.userTxt)
        val itemlayout: ConstraintLayout = itemView.findViewById(R.id.item_layout)

        fun bind(position: Int) {
            txtUserShow.text = dataList[position].firstName
            itemlayout.setOnClickListener {
                it.findNavController().navigate(
                    R.id.action_homeFragment_to_detailFragment,
                    bundleOf("user " to dataList[position])
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {

        return dataList.size
    }

    fun setData(data: List<UserResponse>) {
        val toDoDiffUtils = UserDiffUtils(dataList, data)
        val toDoDiffResults = DiffUtil.calculateDiff(toDoDiffUtils)
        this.dataList = data as MutableList<UserResponse>
        toDoDiffResults.dispatchUpdatesTo(this)
        notifyItemInserted(data.size)
    }

}
