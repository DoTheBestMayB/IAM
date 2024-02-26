package com.im.im.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.im.im.databinding.FragmentIntroBinding
import com.im.im.detail.UserInfoViewModel
import com.im.im.intro.adapter.BannerAdapter
import com.im.im.model.UserInfo

class IntroFragment : Fragment(), UserItemListener {

    private var _binding: FragmentIntroBinding? =
        null // Fragment view보다 Fragment의 lifecycle이 길기 때문에 memory leak을 방지하기 위해 null처리 필요
    private val binding: FragmentIntroBinding // xml에 있는 view에 접근하도록 해주는 변수, viewBinding
        get() = _binding!!

    private val userInfoViewModel: UserInfoViewModel by activityViewModels() // 팀원에 대한 정보가 들어있는 viewModel
    private lateinit var bannerAdapter: BannerAdapter

    override fun onClick(userInfo: UserInfo) {
        // TODO : Dialog 표시
    }

    override fun changedTo(position: Int) {
        val sizeOfAll = userInfoViewModel.info.value?.size ?: throw IllegalArgumentException()
        changeExpandBannerButton(position, sizeOfAll)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMarquee()
        setBanner()
        setObserve()
        loadData()
    }

    override fun onDestroyView() {
        _binding =
            null // Fragment view보다 Fragment의 lifecycle이 길기 때문에 memory leak을 방지하기 위해 null처리 필요

        super.onDestroyView()
    }

    private fun setMarquee() {
        binding.textViewTeam.isSelected = true
    }

    private fun setBanner() {
        bannerAdapter = BannerAdapter(this)
        binding.recyclerviewBanner.adapter = bannerAdapter
    }

    private fun loadData() {
        userInfoViewModel.init()
    }

    private fun setObserve() {
        userInfoViewModel.info.observe(viewLifecycleOwner) {
            bannerAdapter.submitList(it)
            binding.expandBannerButton.visibility =
                if (it.isNotEmpty()) View.VISIBLE else View.INVISIBLE
            changeExpandBannerButton(1, it.size)
        }
    }

    private fun changeExpandBannerButton(index: Int, sizeOfAll: Int) {
        val text = "$index/$sizeOfAll 모두보기" // TODO : String Resources로 분리하기
        binding.expandBannerButton.text = text
    }

}