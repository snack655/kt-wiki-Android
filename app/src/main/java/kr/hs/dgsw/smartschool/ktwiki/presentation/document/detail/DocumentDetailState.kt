package kr.hs.dgsw.smartschool.ktwiki.presentation.document.detail

import kr.hs.dgsw.smartschool.ktwiki.domain.model.DocumentDetail

data class DocumentDetailState(
    val isLoading: Boolean = false,
    val documents: DocumentDetail? = null,
    val error: String = ""
)
