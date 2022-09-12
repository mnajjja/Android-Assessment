package com.vama.assessment.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vama.assessment.R
import com.vama.assessment.databinding.ImageItemBinding

class ImagesAdapter(): ListAdapter<String, ImagesAdapter.ViewHolder>(DiffUtilCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ImageItemBinding = ImageItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))


    inner class ViewHolder(private val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(image: String){
//            Picasso.get().load(user.avatar).into(binding.userAvatar)
//            binding.clickListener = listener
        }
    }

    class DiffUtilCallback: DiffUtil.ItemCallback<String>(){

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            if (oldItem == newItem) {
                return true
            }
            return false
        }
    }
}