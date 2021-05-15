package com.example.testapp.ui.home.adaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.databinding.ItemCarBinding
import com.example.testapp.databinding.ItemManufacturerBinding
import com.example.testapp.model.Item

class ItemsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_LOADING -> LoadingHolder.from(parent)
            ITEM_VIEW_TYPE_MANUFACTURER -> ManufacturerHolder.from(parent)
            ITEM_VIEW_TYPE_CAR -> CarHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder) {
            is LoadingHolder -> {}
            is ManufacturerHolder -> holder.bind(item as Item.Manufacturer)
            is CarHolder -> holder.bind(item as Item.Car)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Item.LoadingIndicator -> ITEM_VIEW_TYPE_LOADING
            is Item.Manufacturer -> ITEM_VIEW_TYPE_MANUFACTURER
            is Item.Car -> ITEM_VIEW_TYPE_CAR
        }
    }

    fun updateItems(newItems: List<Item>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    class LoadingHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        companion object {
            fun from(parent: ViewGroup): LoadingHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_loading, parent, false)
                return LoadingHolder(view)
            }
        }
    }

    class ManufacturerHolder(private val binding: ItemManufacturerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item.Manufacturer) {
            binding.manufacturer = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ManufacturerHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemManufacturerBinding.inflate(layoutInflater, parent, false)
                return ManufacturerHolder(binding)
            }
        }
    }

    class CarHolder(private val binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(car: Item.Car) {
            binding.car = car
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CarHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCarBinding.inflate(layoutInflater, parent, false)
                return CarHolder(binding)
            }
        }
    }

    private val ITEM_VIEW_TYPE_LOADING = 0
    private val ITEM_VIEW_TYPE_MANUFACTURER = 1
    private val ITEM_VIEW_TYPE_CAR = 2
}