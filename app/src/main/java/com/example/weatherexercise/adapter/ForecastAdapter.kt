package com.example.weatherexercise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherexercise.R
import com.example.weatherexercise.model.ForecastDetails
import com.example.weatherexercise.model.Weather


class ForecastAdapter(
    private val dataSet:
    List<ForecastDetails>? = mutableListOf(),
    private val listener: (ForecastDetails) -> Unit
) :
    RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ForecastViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.forecast_row_item, viewGroup, false)

        return ForecastViewHolder(view)
    }


    override fun getItemCount() = dataSet?.size ?: 0


    inner class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var tempTextView: TextView = itemView.findViewById(R.id.temp_textview)
        private var conTextView: TextView = itemView.findViewById(R.id.condition_textview)

        fun updateInfo(item: ForecastDetails?) {
            if (item != null && item.weather != null) {

                var weather: Weather = item.weather[0]

                tempTextView.text = "Temp: ${item.main?.temp.toString()}"
                conTextView.text = weather.main.toString()

            };
        }
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val item = dataSet?.get(position)
        holder.updateInfo(item)

        holder.itemView.setOnClickListener {
            if (item != null) {
                listener(item)
            }
        }

    }


}