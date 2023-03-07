package com.fo.dev.quran.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fo.dev.quran.R
import com.fo.dev.quran.ui.adapters.SurahAdapter.ViewHolder
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import com.fo.dev.quran.Surah
import com.fo.dev.quran.SurahType

class SurahAdapter(val context: Context, val surahList: List<Surah>) :
    RecyclerView.Adapter<ViewHolder>() {

    private lateinit var gotoPage: (surah: Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_surah, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return surahList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val surah = surahList[position]
        println(surah)
        holder.apply {
            surahName.text = surah.name
            println(surah.name)
            surahNumber.text = surah.number.toString()
            println(surahNumber.text)
            surahAyahCount.text = " عدد الآيات: ${surah.ayahCount}"
            surahPageRange.text = "من ${surah.pageRange.first} الى ${surah.pageRange.second}"
            val type =
                if (surah.type == SurahType.MADANIA) R.drawable.madania else R.drawable.makiya
            surahType.setImageDrawable(AppCompatResources.getDrawable(context, type))
            itemView.setOnClickListener {
                gotoPage(position)
            }
        }
    }

    fun setOnItemSelected(action: (surah: Int) -> Unit) {
        gotoPage = action
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val surahType: ImageView = itemView.findViewById(R.id.surah_type)
        val surahName: TextView = itemView.findViewById(R.id.surah_name)
        val surahAyahCount: TextView = itemView.findViewById(R.id.surah_ayah_count)
        val surahPageRange: TextView = itemView.findViewById(R.id.surah_page_range)
        val surahNumber: TextView = itemView.findViewById(R.id.surah_number)
    }
}
