package edu.gvsu.cis.kmpwordy

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier

interface WordScreenFactory {
    fun createWordScreen(): Any
}
val LocalWordScreenProvider = staticCompositionLocalOf<WordScreenFactory?> {  null }
@Composable
expect fun WordScreen(modifier: Modifier = Modifier, viewModel: AppViewModel)