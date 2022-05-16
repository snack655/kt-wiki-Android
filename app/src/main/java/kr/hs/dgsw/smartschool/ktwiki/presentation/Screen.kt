package kr.hs.dgsw.smartschool.ktwiki.presentation

sealed class Screen(val route: String) {
    object DocumentListScreen: Screen("document_list_screen")
    object DocumentDetailScreen: Screen("document_detail_screen")
}
