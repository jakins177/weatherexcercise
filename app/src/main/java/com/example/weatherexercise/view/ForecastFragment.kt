package com.example.weatherexercise.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherexercise.adapter.ForecastAdapter
import com.example.weatherexercise.databinding.FragmentForecastBinding
import com.example.weatherexercise.model.ForecastData

class ForecastFragment : Fragment() {
    private val TAG = "ForecastFragment"
    private var _binding: FragmentForecastBinding? = null
    private val binding get() = _binding!!
    private val args: ForecastFragmentArgs by navArgs()
    private lateinit var wData: ForecastData

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentForecastBinding.inflate(layoutInflater, container, false).also {
        _binding = it

        wData = args.wData

        initViews();


    }.root


    private fun initViews() = with(binding) {
        //setup recycle view
        rvList.hasFixedSize()
        rvList.layoutManager = LinearLayoutManager(context)
        rvList.itemAnimator = DefaultItemAnimator()

        rvList.adapter = ForecastAdapter(wData.list) { item ->

            val directions =
                ForecastFragmentDirections.actionForecastFragmentToForecastDetailFragment(item)
            view?.findNavController()?.navigate(directions)

        }


    }


}