package kr.hs.dgsw.smartschool.ktwiki.domain.repository

import kr.hs.dgsw.smartschool.ktwiki.data.remote.dto.DocumentDto

interface KTwikiRepository {
    suspend fun getDocuments(): List<DocumentDto>
    suspend fun getDocumentByIdx(idx: Int): DocumentDto
}