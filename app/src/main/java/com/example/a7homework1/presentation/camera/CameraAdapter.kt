package com.example.a7homework1.presentation.camera

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.a7homework1.databinding.ItemCameraBinding
import com.example.a7homework1.model.CameraModel

class CameraAdapter( private val cameras: List<CameraModel.Data.Camera>
) : RecyclerView.Adapter<CameraAdapter.ViewHolder>() {


 /*   fun addCamera(cameraList: List<CameraModel.Data.Camera>){
        cameras.clear()
        cameras.addAll(cameraList)
        notifyDataSetChanged()
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CameraAdapter.ViewHolder {
        return ViewHolder(
            ItemCameraBinding.inflate
                (LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CameraAdapter.ViewHolder, position: Int) {
        holder.bind(cameras[position])
    }

    override fun getItemCount(): Int {
        return cameras.size
    }


    inner class ViewHolder(private val binding: ItemCameraBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(camera: CameraModel.Data.Camera) {
            binding.tvCam.text = camera.name
            binding.imgCamera.load(camera.snapshot)
        }
    }
}