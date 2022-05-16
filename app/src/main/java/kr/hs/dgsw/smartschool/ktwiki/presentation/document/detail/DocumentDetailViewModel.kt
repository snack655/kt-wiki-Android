package kr.hs.dgsw.smartschool.ktwiki.presentation.document.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kr.hs.dgsw.smartschool.ktwiki.common.Constants
import kr.hs.dgsw.smartschool.ktwiki.common.Resource
import kr.hs.dgsw.smartschool.ktwiki.domain.usecase.document.GetDocumentUseCase
import kr.hs.dgsw.smartschool.ktwiki.presentation.document.list.DocumentListState
import javax.inject.Inject

@HiltViewModel
class DocumentDetailViewModel @Inject constructor(
    private val getDocumentUseCase: GetDocumentUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(){
    private val _state = mutableStateOf(DocumentDetailState())
    val state: State<DocumentDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_DOCUMENT_IDX)?.let { idx ->
            getDocuments(idx.toInt())
        }
    }

    private fun getDocuments(idx: Int) {
        getDocumentUseCase(idx).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = DocumentDetailState(document = result.data)
                }

                is Resource.Error -> {
                    _state.value = DocumentDetailState(
                        error = result.message ?: "알 수 없는 오류가 발생했습니다."
                    )
                }

                is Resource.Loading -> {
                    _state.value = DocumentDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}