package kr.hs.dgsw.smartschool.ktwiki.data.remote.dto

import kr.hs.dgsw.smartschool.ktwiki.domain.model.Document
import kr.hs.dgsw.smartschool.ktwiki.domain.model.DocumentDetail

data class DocumentDto (
    val idx: Int,
    val title: String,
    val text: String,
    val hits: Int,
    val created_at: String,
    val updated_at: String,
    val category: Category
)

fun DocumentDto.toDocument(): Document {
    return Document(
        idx = idx,
        title = title,
        hits = hits
    )
}

fun DocumentDto.toDocumentDetail(): DocumentDetail {
    return DocumentDetail(
        idx = idx,
        title = title,
        text = text,
        hits = hits,
        created_at = created_at,
        updated_at = updated_at,
        category = category
    )
}