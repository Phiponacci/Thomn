package com.leo.dev.quran.ui

import android.app.Dialog
import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.leo.dev.quran.SurahRepository
import com.leo.dev.quran.databinding.IndexDialogBinding
import com.leo.dev.quran.ui.adapters.SurahAdapter


class IndexDialog(context: Context) : Dialog(context) {
    private var _binding: IndexDialogBinding? = null
    val binding get() = _binding!!
    lateinit var gotoPage: (surah: Int)->Unit
    init {
        _binding = IndexDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.indexRecyclerview.layoutManager = LinearLayoutManager(context)
    }

    fun setOnItemSelected(action: (surah: Int)->Unit) {
        gotoPage = action
        val surahList = SurahRepository.surahList
        val adapter = SurahAdapter(context, surahList)
        adapter.setOnItemSelected(gotoPage)
        binding.indexRecyclerview.adapter = adapter
    }
}