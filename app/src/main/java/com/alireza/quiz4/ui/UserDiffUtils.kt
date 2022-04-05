package com.alireza.quiz4.ui

import androidx.recyclerview.widget.DiffUtil
import com.alireza.quiz4.data.model.UserResponse

class UserDiffUtils(private val oldList: MutableList<UserResponse>,private val newList: List<UserResponse>) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] === newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition]._id == newList[newItemPosition]._id
                    && oldList[oldItemPosition].firstName == newList[newItemPosition].firstName
                    && oldList[oldItemPosition].lastName == newList[newItemPosition].lastName
                    && oldList[oldItemPosition].nationalCode == newList[newItemPosition].nationalCode
                    && oldList[oldItemPosition].hobbies == newList[newItemPosition].hobbies
        }

}
