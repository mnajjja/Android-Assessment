package com.vama.assessment.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import com.vama.assessment.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding
    private lateinit var imagesAdapter: ImagesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            imagesAdapter = ImagesAdapter(it)
        }
        binding.imagesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, VERTICAL, false)
            adapter = imagesAdapter
        }
        bindView()
    }

    private fun bindView() {
        viewModel.imageUrlStrings
        viewModel.imageUrlStrings.observe(viewLifecycleOwner) {
            imagesAdapter.submitList(it.toMutableList())
        }
    }
}