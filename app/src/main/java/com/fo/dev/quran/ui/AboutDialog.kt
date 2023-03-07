package com.fo.dev.quran.ui

import android.app.Dialog
import android.content.Context
import com.fo.dev.quran.databinding.AboutDialogBinding


class AboutDialog(context: Context) : Dialog(context) {
    private var _binding: AboutDialogBinding? = null
    val binding get() = _binding!!

    init {
        _binding = AboutDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.setOnClickListener {
            hide()
        }
    }
}