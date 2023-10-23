package com.example.a7homework1.presentation.doors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.a7homework1.R
import com.example.a7homework1.databinding.FragmentDoorsBinding
import com.example.a7homework1.model.DoorsModel
import com.example.a7homework1.utils.SwipeController


class DoorsFragment : Fragment() {
    private lateinit var binding: FragmentDoorsBinding


    val dataDoors = listOf(
        DoorsModel.Data(false, 1, "Door 1", "Room A", R.drawable.clock),
        DoorsModel.Data(false, 2, "Door 2", "Room B", R.drawable.clock),
        DoorsModel.Data(false, 3, "Door 3", "Room C", R.drawable.clock),
        DoorsModel.Data(false, 4, "Door 4", "Room E", R.drawable.clock),
    )


    private val adapter = DoorsAdapter(dataDoors)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoorsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcViewDoorE.adapter = adapter
        binding.rcViewDoorE.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))

        val itemTouchHelper = ItemTouchHelper(object : SwipeController(binding.rcViewDoorE){
            override fun instantiateUnderlayButton(position: Int): List<UnderlayButton> {
                val editButton = onEditClickListener(position)
                val selectButton = onSelectClickListener(position)
                return listOf(editButton, selectButton)
            }
        })
        itemTouchHelper.attachToRecyclerView(binding.rcViewDoorE)
    }

    private fun onEditClickListener(position: Int):
            SwipeController.UnderlayButton {
            return SwipeController.UnderlayButton(
                requireContext(),
                "Edit",
                20f,
                R.color.grey,
                R.drawable.edit,
                object : SwipeController.UnderlayButtonClickListener{
                    override fun onClick() {
                        Toast.makeText(
                            requireContext(),
                            "Edit clicked for position $position",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            )
    }

    private fun onSelectClickListener(position: Int)
        : SwipeController.UnderlayButton {
            return SwipeController.UnderlayButton(
                requireContext(),
                "Favor",
                20f,
                R.color.grey,
                R.drawable.star,
                object :SwipeController.UnderlayButtonClickListener{
                    override fun onClick() {
                        Toast.makeText(
                            requireContext(),
                            "Select clicked for position: $position",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            )
    }

    companion object {
        fun newInstance() = DoorsFragment()
    }
}