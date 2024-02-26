package com.im.im.intro.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.im.im.databinding.ItemTeamBannerBinding
import com.im.im.intro.UserItemListener
import com.im.im.model.UserInfo

class BannerAdapter(
    private val userItemListener: UserItemListener,
) : ListAdapter<UserInfo, BannerAdapter.BannerViewHolder>(diffCallback) {

    inner class BannerViewHolder(private val binding: ItemTeamBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(userInfo: UserInfo) {
            binding.name.text = userInfo.name
            binding.picture.text = userInfo.picture
            binding.introduction.text = userInfo.shortIntroduction

            binding.root.setOnClickListener {
                userItemListener.onClick(userInfo)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        return BannerViewHolder(
            ItemTeamBannerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<UserInfo>() {
            override fun areItemsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: UserInfo, newItem: UserInfo): Boolean {
                return oldItem == newItem
            }

        }
    }
}