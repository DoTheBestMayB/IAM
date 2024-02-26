package com.im.im.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.im.im.databinding.FragmentIntroBinding
import com.im.im.detail.UserInfoViewModel

class IntroFragment : Fragment() {

    private var _binding: FragmentIntroBinding? = null // Fragment view보다 Fragment의 lifecycle이 길기 때문에 memory leak을 방지하기 위해 null처리 필요
    private val binding: FragmentIntroBinding // xml에 있는 view에 접근하도록 해주는 변수, viewBinding
        get() = _binding!!

    private val userInfoViewModel: UserInfoViewModel by activityViewModels() // 팀원에 대한 정보가 들어있는 viewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        _binding = null // Fragment view보다 Fragment의 lifecycle이 길기 때문에 memory leak을 방지하기 위해 null처리 필요

        super.onDestroy()
    }
}