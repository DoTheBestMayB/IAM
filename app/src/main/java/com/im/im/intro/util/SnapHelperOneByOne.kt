package com.im.im.intro.util

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.im.im.intro.BannerLocationListener

class SnapHelperOneByOne(
    private val bannerLocationListener: BannerLocationListener,
): LinearSnapHelper() {

    override fun findTargetSnapPosition(
        layoutManager: RecyclerView.LayoutManager?,
        velocityX: Int,
        velocityY: Int
    ): Int {

        if (layoutManager !is RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return RecyclerView.NO_POSITION
        }
        val currentView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION

        val myLayoutManager = layoutManager as LinearLayoutManager

        val firstPosition = myLayoutManager.findFirstVisibleItemPosition()
        val lastPosition = myLayoutManager.findLastVisibleItemPosition()

        var currentPosition = layoutManager.getPosition(currentView)

        if (velocityX > 400) {
            currentPosition = lastPosition
        } else if (velocityX < 400) {
            currentPosition = firstPosition
        }

        bannerLocationListener.changedTo(currentPosition + 1)
        return currentPosition
    }
}