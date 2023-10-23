package com.example.a7homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a7homework1.core.network.RemoteDataSource
import com.example.a7homework1.core.network.RetrofitClient
import com.example.a7homework1.databinding.ActivityMainBinding
import com.example.a7homework1.domain.Repository
import com.example.a7homework1.presentation.camera.CameraFragment
import com.example.a7homework1.presentation.doors.DoorsFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
   // private val list = arrayListOf<Car>()
    private val fragList = listOf(
       CameraFragment.newInstance(),
       DoorsFragment.newInstance())

    private val fragListTitles = listOf(
        "Камеры",
        "Двери"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = VpAdapter(this,fragList)
        binding.vp.adapter = adapter
        TabLayoutMediator(binding.tabLayout,binding.vp){
                tab,pos-> tab.text = fragListTitles[pos]

        }.attach()

    }
    companion object{
        val retrofitClient = RetrofitClient().createApiService()
        private val remoteDataSource = RemoteDataSource(retrofitClient)
        val repository = Repository(remoteDataSource)

    }
}