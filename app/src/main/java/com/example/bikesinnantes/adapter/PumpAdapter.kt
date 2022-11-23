package com.example.bikesinnantes.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.bikesinnantes.R
import com.example.bikesinnantes.model.Pump

class PumpAdapter(private val pumps:List<Pump>, private val context: Context) :
    RecyclerView.Adapter<PumpAdapter.ViewHolder>() {


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardView : CardView = itemView.findViewById(R.id.cardViewPump)
        val address : TextView = itemView.findViewById(R.id.adresse)
        val carburant : TextView = itemView.findViewById(R.id.carburant)
        val prix : TextView = itemView.findViewById(R.id.prix)
        val updateDate : TextView = itemView.findViewById(R.id.updateDate)
        val distanceTo : TextView = itemView.findViewById(R.id.distanceTo)
        val pumpView : ImageView = itemView.findViewById(R.id.pumpView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_pump_item, parent, false)
        return ViewHolder(view);
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pump = pumps[position]
        holder.address.text = pump.adresse + "\uD83D\uDCCD"
        holder.carburant.text = pump.carburant
        holder.prix.text = pump.prix.toString()


        if (pump.prix <= 1.5){
            holder.prix.setTextColor(context.getColor(R.color.gas_price_cheap))
            holder.pumpView.setImageResource(R.drawable.ic_baseline_local_gas_station_24)
        }else if (pump.prix >= 1.5 && pump.prix <= 1.8){
            holder.prix.setTextColor(context.getColor(R.color.gas_price_medium))
            holder.pumpView.setImageResource(R.drawable.ic_baseline_local_gas_station_orange)
        }else {
            holder.prix.setTextColor(context.getColor(R.color.gas_price_expensive))
            holder.pumpView.setImageResource(R.drawable.ic_baseline_local_gas_station_red)
        }


    }

    override fun getItemCount(): Int {
        return pumps.size
    }
}