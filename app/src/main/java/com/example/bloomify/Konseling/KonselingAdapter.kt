package com.example.bloomify.Konseling

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class KonselingAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ChattingFragment()
            1 -> BookingFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}