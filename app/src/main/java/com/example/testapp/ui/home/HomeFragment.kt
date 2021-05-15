package com.example.testapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testapp.databinding.FragmentHomeBinding
import com.example.testapp.ui.base.BaseFragment
import com.example.testapp.ui.home.adaper.ItemsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModel()
    private lateinit var adapter : ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentHomeBinding = FragmentHomeBinding.inflate(
            inflater, container, false).apply {
                lifecycleOwner = viewLifecycleOwner
        }
        adapter = ItemsAdapter()
        binding.recycler.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.items.observe(viewLifecycleOwner) {
            adapter.updateItems(it)
        }
    }
}