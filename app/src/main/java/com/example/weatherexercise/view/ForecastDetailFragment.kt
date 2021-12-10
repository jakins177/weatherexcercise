package com.example.weatherexercise.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.weatherexercise.databinding.FragmentForecastDetailBinding
import com.example.weatherexercise.model.ForecastDetails
import com.example.weatherexercise.model.Weather

class ForecastDetailFragment : Fragment() {
    private val TAG = "ForecastDetailFragment"
    private var _binding: FragmentForecastDetailBinding? = null
    private val binding get() = _binding!!
    private val args: ForecastDetailFragmentArgs by navArgs()
    private lateinit var fDetail: ForecastDetails

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentForecastDetailBinding.inflate(layoutInflater, container, false).also {
        _binding = it

        fDetail = args.fDetail
        initViews()


    }.root


    private fun initViews() = with(binding) {

        if (fDetail != null && fDetail.weather != null) {

            var weather: Weather = fDetail.weather!![0]

            binding.feelsLikeTextView.text = "Feels like ${fDetail.main?.feelsLike.toString()}"
            binding.tempTextView.text = fDetail.main?.temp.toString()
            binding.weatherDescTextView.text = weather.description.toString()
            binding.weatherTextView.text = weather.main.toString()
        }

    }


}