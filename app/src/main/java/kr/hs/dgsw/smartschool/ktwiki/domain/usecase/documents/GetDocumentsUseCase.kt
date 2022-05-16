package kr.hs.dgsw.smartschool.ktwiki.domain.usecase.documents

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.hs.dgsw.smartschool.ktwiki.common.Resource
import kr.hs.dgsw.smartschool.ktwiki.data.remote.dto.toDocument
import kr.hs.dgsw.smartschool.ktwiki.domain.model.Document
import kr.hs.dgsw.smartschool.ktwiki.domain.repository.KTwikiRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDocumentsUseCase @Inject constructor(
    private val repository: KTwikiRepository
) {
    operator fun invoke(): Flow<Resource<List<Document>>> = flow {
        try {
            emit(Resource.Loading<List<Document>>())
            val documents = repository.getDocuments().map { it.toDocument() }
            emit(Resource.Success<List<Document>>(documents))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Document>>(e.localizedMessage ?: "알 수 없는 오류가 발생했습니다."))
        } catch (e: IOException) {
            emit(Resource.Error<List<Document>>("서버에 도달 할 수 없습니다. 네트워크 상태를 확인해 주세요."))
        }
    }
}