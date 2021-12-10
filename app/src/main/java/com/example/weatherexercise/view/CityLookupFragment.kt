package com.example.weatherexercise.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.weatherexercise.viewmodel.WeatherViewModel
import com.example.weatherexercise.databinding.FragmentCitylookupBinding
import com.example.weatherexercise.util.ApiState

class CityLookupFragment : Fragment() {
    private val TAG = "CityLookupFragment"
    private var _binding: FragmentCitylookupBinding? = null
    private val binding get() = _binding!!
    private val weatherViewModel by activityViewModels<WeatherViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCitylookupBinding.inflate(layoutInflater, container, false).also {
        _binding = it
        setupObservers()


        binding.lookUpButton.setOnClickListener {
            Log.i(TAG, "onCreateView: lookupbutton clicked")

            val cityName = binding.cityNameField.getText().toString();


            if (cityName.equals("")) {
                Toast.makeText(this.activity, "You did not enter a city name", Toast.LENGTH_SHORT)
                    .show();

            } else {
                weatherViewModel.makeForecastFetch(cityName)
            }

        };


    }.root

    private fun setupObservers() = with(weatherViewModel) {
        weatherState.observe(viewLifecycleOwner) { state ->

            if (state is ApiState.Success) {

                val wData = state.data;


                val directions =
                    CityLookupFragmentDirections.actionCityLookupFragmentToForecastFragment(wData)
                view?.findNavController()?.navigate(directions)

            }


        }

    }

}

