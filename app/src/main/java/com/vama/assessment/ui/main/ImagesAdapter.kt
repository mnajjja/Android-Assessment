package com.vama.assessment.ui.main

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.vama.assessment.ImageDownloader
import com.vama.assessment.databinding.ImageItemBinding

class ImagesAdapter(val context: Context): ListAdapter<String, ImagesAdapter.ViewHolder>(DiffUtilCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ImageItemBinding = ImageItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(private val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(imageUrl: String, newIndex: Int){
            ImageDownloader.downloadImage(context, imageUrl) {
                if (oldPosition == newIndex || oldPosition == -1) {
                    binding.ivImage.setImageDrawable(it)
                }
            }
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