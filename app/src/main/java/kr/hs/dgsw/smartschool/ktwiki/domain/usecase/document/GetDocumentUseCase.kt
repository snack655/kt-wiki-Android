package kr.hs.dgsw.smartschool.ktwiki.domain.usecase.document

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.hs.dgsw.smartschool.ktwiki.common.Resource
import kr.hs.dgsw.smartschool.ktwiki.data.remote.dto.toDocumentDetail
import kr.hs.dgsw.smartschool.ktwiki.domain.model.DocumentDetail
import kr.hs.dgsw.smartschool.ktwiki.domain.repository.KTwikiRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDocumentUseCase @Inject constructor(
    private val repository: KTwikiRepository
) {
    operator fun invoke(idx: Int): Flow<Resource<DocumentDetail>> = flow {
        try {
            emit(Resource.Loading<DocumentDetail>())
            val document = repository.getDocumentByIdx(idx).toDocumentDetail()
            emit(Resource.Success<DocumentDetail>(document))
        } catch (e: HttpException) {
            emit(Resource.Error<DocumentDetail>(e.localizedMessage ?: "알 수 없는 오류가 발생했습니다."))
        } catch (e: IOException) {
            emit(Resource.Error<DocumentDetail>("서버에 도달 할 수 없습니다. 네트워크 상태를 확인해 주세요."))
        }
    }
}