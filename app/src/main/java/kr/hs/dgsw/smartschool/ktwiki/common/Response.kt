package kr.hs.dgsw.smartschool.ktwiki.common

data class Response<T>(
    val status: Int,
    val data: T,
    val message: String
)
