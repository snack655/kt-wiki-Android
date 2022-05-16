package kr.hs.dgsw.smartschool.ktwiki.data.remote

import kr.hs.dgsw.smartschool.ktwiki.data.remote.dto.DocumentDto
import retrofit2.http.GET
import retrofit2.http.Path

interface KTwikiApi {
    @GET("/document")
    suspend fun getDocuments(): List<DocumentDto>

    @GET("/document/{idx}")
    suspend fun getDocumentByIdx(@Path("idx") idx: Int): DocumentDto
}