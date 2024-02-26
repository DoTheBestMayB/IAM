package com.im.im.detail

import androidx.lifecycle.ViewModel
import com.im.im.model.UserInfo

class UserInfoViewModel: ViewModel() {

    // 팀원에 대한 정보가 들어 있는 변수
    private val userInfo: Map<String, UserInfo> = emptyMap()


    fun getUser(name: String): UserInfo = userInfo[name] ?: throw IllegalArgumentException()
}