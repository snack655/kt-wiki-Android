package kr.hs.dgsw.smartschool.ktwiki.domain.model

import kr.hs.dgsw.smartschool.ktwiki.data.remote.dto.Category

data class DocumentDetail(
    val idx: Int,
    val title: String,
    val text: String,
    val hits: Int,
    val created_at: String,
    val updated_at: String,
    val category: Category
)
