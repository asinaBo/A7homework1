package com.example.a7homework1.presentation.doors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.a7homework1.databinding.ItemDoorTitleBinding
import com.example.a7homework1.data.model.DoorsModel

class DoorsAdapter : RecyclerView.Adapter<DoorsAdapter.ViewHolder>() {

    private var doorsList = mutableListOf<DoorsModel.Data>()

    fun addData(door: List<DoorsModel.Data>) {
        doorsList.clear()
        doorsList.addAll(door)
        notifyItemRangeInserted(doorsList.size, door.size - doorsList.size)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDoorTitleBinding.inflate
                (LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return doorsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(doorsList[position])

    }

    inner class ViewHolder(private val binding: ItemDoorTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var isDetailsVisible = false

        fun bind(door: DoorsModel.Data) {
            binding.itemTitle.text = door.name
            binding.itemImage.load(door.snapshot)

            itemView.setOnClickListener {
                if (isDetailsVisible) {
                    HideDetails()
                } else {
                    ShowDetails(door)
                }
                isDetailsVisible = !isDetailsVisible
            }
        }

        private fun ShowDetails(door: DoorsModel.Data) {
            binding.tvDoorAD.visibility = View.VISIBLE
            binding.imgDoorAD.visibility = View.VISIBLE
            binding.imgDoorAD.load(door.snapshot)
            binding.imgOnline.visibility = View.VISIBLE
            binding.tvOnline.visibility = View.VISIBLE

            binding.itemImage.visibility = View.GONE
            binding.itemTitle.visibility = View.GONE
        }

        private fun HideDetails() {
            binding.tvDoorAD.visibility = View.GONE
            binding.imgDoorAD.visibility = View.GONE
            binding.imgOnline.visibility = View.GONE
            binding.tvOnline.visibility = View.GONE
            binding.itemTitle.visibility = View.VISIBLE
            binding.itemImage.visibility = View.VISIBLE
        }
    }
}