package com.example.testapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.R
import com.example.testapp.databinding.FragmentHomeBinding
import com.example.testapp.ui.base.BaseFragment
import com.example.testapp.ui.home.adaper.ItemsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModel()
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