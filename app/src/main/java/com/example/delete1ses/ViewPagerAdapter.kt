package com.example.delete1ses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(val list: List<PagerData>): RecyclerView.Adapter<ViewPagerAdapter.VH>() {
    class VH(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var OnBoardText = itemView.findViewById<TextView>(R.id.OnBoardText)
        val OnBoardImg = itemView.findViewById<ImageView>(R.id.OnBoardImg)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.onoard_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.OnBoardText.text = list[position].text
        holder.OnBoardImg.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context,list[position].img))
    }
}