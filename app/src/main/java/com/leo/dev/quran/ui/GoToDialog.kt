package com.leo.dev.quran.ui

import android.app.Dialog
import android.content.Context
import com.leo.dev.quran.databinding.GotoDialogBinding


class GoToDialog(context: Context) : Dialog(context) {
    private var _binding: GotoDialogBinding? = null
    val binding get() = _binding!!
    lateinit var gotoPage: (hizb: Int, thomn: Int)->Unit
    init {
        _binding = GotoDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.gotoBtn.setOnClickListener {
            val hizb = binding.hizb.selectedItem.toString().toInt()
            val thomn = binding.thomn.selectedItem.toString().toInt()
            gotoPage(hizb, thomn)
        }
    }

    fun setOnGotoClicked(action: (hizb: Int, thomn: Int)->Unit){
        gotoPage = action
    }
}