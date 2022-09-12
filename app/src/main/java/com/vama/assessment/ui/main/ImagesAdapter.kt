package com.vama.assessment.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.vama.assessment.databinding.ImageItemBinding

class ImagesAdapter: ListAdapter<String, ImagesAdapter.ViewHolder>(DiffUtilCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ImageItemBinding = ImageItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(private val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(imageUrl: String, newIndex: Int){
            binding.ivImage.load(imageUrl)
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }
}