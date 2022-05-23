package kr.hs.dgsw.smartschool.ktwiki.data.repository

import kr.hs.dgsw.smartschool.ktwiki.data.remote.KTwikiApi
import kr.hs.dgsw.smartschool.ktwiki.data.remote.dto.DocumentDto
import kr.hs.dgsw.smartschool.ktwiki.domain.repository.KTwikiRepository
import javax.inject.Inject

class KTwikiRepositoryImpl @Inject constructor(
    private val api: KTwikiApi
): KTwikiRepository {
    override suspend fun getDocuments(): List<DocumentDto> {
        return api.getDocuments().data
    }

    override suspend fun getDocumentByIdx(idx: Int): DocumentDto {
        return api.getDocumentByIdx(idx).data
    }

}