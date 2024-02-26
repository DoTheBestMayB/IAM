package com.im.im.intro

import com.im.im.model.UserInfo

interface UserItemListener {

    fun onClick(userInfo: UserInfo)
}