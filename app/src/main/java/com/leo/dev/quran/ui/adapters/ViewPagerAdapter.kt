package com.leo.dev.quran.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leo.dev.quran.R
import com.leo.dev.quran.ui.adapters.ViewPagerAdapter.ViewHolder
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(val images: List<Int>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_viewpager, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentImage = images[position]
        holder.imageView.setImageResource(currentImage)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}
