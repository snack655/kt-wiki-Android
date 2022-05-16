package kr.hs.dgsw.smartschool.ktwiki.presentation.document.list

import kr.hs.dgsw.smartschool.ktwiki.domain.model.Document

data class DocumentListState(
    val isLoading: Boolean = false,
    val documents: List<Document> = emptyList(),
    val error: String = ""
)
