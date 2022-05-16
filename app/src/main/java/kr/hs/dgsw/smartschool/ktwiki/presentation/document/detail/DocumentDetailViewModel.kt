package kr.hs.dgsw.smartschool.ktwiki.presentation.document.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kr.hs.dgsw.smartschool.ktwiki.domain.usecase.document.GetDocumentUseCase
import javax.inject.Inject

@HiltViewModel
class DocumentDetailViewModel @Inject constructor(
    private val getDocument: GetDocumentUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(){
    private val _state = mutableStateOf(DocumentDetailState())
    val state: State<DocumentDetailState> = _state

    init {
        //getDocuments()
    }

    private fun getDocuments() {

    }
}