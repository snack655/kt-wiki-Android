package kr.hs.dgsw.smartschool.ktwiki.presentation.document.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kr.hs.dgsw.smartschool.ktwiki.common.Resource
import kr.hs.dgsw.smartschool.ktwiki.domain.usecase.documents.GetDocumentsUseCase
import javax.inject.Inject

@HiltViewModel
class DocumentListViewModel @Inject constructor(
    private val getDocumentsUseCase: GetDocumentsUseCase
): ViewModel() {
    private val _state = mutableStateOf(DocumentListState())
    val state: State<DocumentListState> = _state

    init {
        getDocuments()
    }

    private fun getDocuments() {
        getDocumentsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = DocumentListState(documents = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = DocumentListState(
                        error = result.message ?: "알 수 없는 오류가 발생했습니다."
                    )
                }

                is Resource.Loading -> {
                    _state.value = DocumentListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}