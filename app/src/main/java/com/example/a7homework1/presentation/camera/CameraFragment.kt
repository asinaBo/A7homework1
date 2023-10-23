package com.example.a7homework1.presentation.camera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.a7homework1.MainActivity

import com.example.a7homework1.R
import com.example.a7homework1.core.base.BaseFragment
import com.example.a7homework1.databinding.FragmentCameraBinding
import com.example.a7homework1.data.model.CameraModel


class CameraFragment : BaseFragment<FragmentCameraBinding>() {

    private val adapter = CameraAdapter()
    private val viewModel = CameraViewModel(MainActivity.repository)

    /*override val viewModel: CameraViewModel
        get() = CameraViewModel(MainActivity.repository)*/

    override fun inflaterViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCameraBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcViewCam.adapter = adapter
        init()
        initLiveData()
    }

    private fun init() {
        viewModel.fetchCameraData()
    }

    private fun initLiveData() {
        viewModel.loading.observe(viewLifecycleOwner) { loading ->
            if (loading) {
                binding.shimmer.visibility = View.VISIBLE
                binding.shimmer.startShimmer()
            }
            else {
                binding.shimmer.stopShimmer()
                binding.shimmer.visibility = View.GONE
            }
        }

        viewModel.camera.observe(viewLifecycleOwner) { cameras ->
            initRecyclerView(cameras.data.cameras)
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerView(cameras: List<CameraModel.Data.Camera>) {
        adapter.addData(cameraList = cameras)
        binding.rcViewCam.adapter = adapter

    }


    companion object {
        fun newInstance() = CameraFragment()
    }
}



