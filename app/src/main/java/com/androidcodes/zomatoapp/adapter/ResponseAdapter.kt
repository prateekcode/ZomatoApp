package com.androidcodes.zomatoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidcodes.zomatoapp.R
import com.androidcodes.zomatoapp.model.Response
import kotlinx.android.synthetic.main.single_item.view.*

class ResponseAdapter(private var responseItem: List<Response>): RecyclerView.Adapter<ResponseAdapter.MyViewHolder>(){

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cuisinesType = view.cuisines_tv
        var restaurantName = view.restaurant_name_tv
        var avgPrice = view.avg_price_tv
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.single_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val response = responseItem[position]
        holder.cuisinesType.text = response.cuisinesType
        holder.restaurantName.text = response.restaurantName
        holder.avgPrice.text = response.avgPrice
    }

    override fun getItemCount(): Int {
        return responseItem.size
    }
}