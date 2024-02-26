package com.im.im.model

data class UserInfo(
    val name: String, // 이름
    val picture: String, // emoji로 대체
    val shortIntroduction: String, // 짧은 자기 소개 내용
    val introduction: String, // 자기 소개 내용
    val role: Role, // 역할
)
