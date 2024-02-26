package com.im.im.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.im.im.model.Role
import com.im.im.model.UserInfo

class UserInfoViewModel: ViewModel() {

    // 팀원에 대한 정보가 들어 있는 변수
    private val userInfo: Map<String, UserInfo> = mapOf(
        "김민수" to UserInfo(
            name = "김민수",
            picture = "ferri",
            shortIntroduction = "안녕하세요 저는 김민수 입니다. 안녕하세요 저는 김민수 입니다. 안녕하세요 저는 김민수 입니다. 안녕하세요 저는 김민수 입니다. 안녕하세요 저는 김민수 입니다. ",
            introduction = "efficiantur",
            role = Role.LEADER
        ),
        "Flora Wood" to UserInfo(
            name = "Flora Wood",
            picture = "detracto",
            shortIntroduction = "alterum alterum alterum alterum alterum alterum alterum alterum alterum alterum alterum ",
            introduction = "egestas",
            role = Role.MEMBER,
        ),
        "Felicia Key" to UserInfo(
            name = "Felicia Key",
            picture = "senectus",
            shortIntroduction = "neque",
            introduction = "graeci",
            role = Role.LEADER
        )
    )

    private val _info = MutableLiveData<List<UserInfo>>()
    val info: LiveData<List<UserInfo>>
        get() = _info


    fun getUser(name: String): UserInfo = userInfo[name] ?: throw IllegalArgumentException()

    fun init() {
        _info.value = userInfo.values.toList()
    }
}