package com.im.im.banner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.im.im.databinding.FragmentBannerBinding

class BannerFragment: Fragment() {

    private var _binding: FragmentBannerBinding? = null
    private val binding: FragmentBannerBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBannerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null

        super.onDestroyView()
    }

    companion object {
        const val BANNER_ARG_OBJ = "object"
    }
}