package com.example.a7homework1.presentation.camera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a7homework1.databinding.FragmentCameraBinding
import com.example.a7homework1.model.CameraModel


class CameraFragment : Fragment() {
    private lateinit var binding: FragmentCameraBinding
    val data = listOf(
        CameraModel.Data.Camera(
            favorites = true,
            id = 1,
            name = "Камера 1",
            rec = true,
            room = "Living Room",
            snapshot = "URL_TO_IMAGE_1"
        ),
        CameraModel.Data.Camera(
            favorites = false,
            id = 2,
            name = "Камера 2",
            rec = false,
            room = "Bedroom",
            snapshot = "URL_TO_IMAGE_2"
        ),
        CameraModel.Data.Camera(
            favorites = false,
            id = 3,
            name = "Камера 3",
            rec = false,
            room = "Bedroom",
            snapshot = "URL_TO_IMAGE_3"
        ),
    )

    private val adapter = CameraAdapter(data)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCameraBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcViewCam.adapter = adapter

    }
    companion object {

        fun newInstance() = CameraFragment()
    }
}