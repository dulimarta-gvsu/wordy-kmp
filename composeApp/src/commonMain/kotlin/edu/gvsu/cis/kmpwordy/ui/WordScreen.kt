package edu.gvsu.cis.kmpwordy.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import edu.gvsu.cis.kmpwordy.AppViewModel

// Use this interface to support expect/actual implementation
interface WordScreenFactory {
    // The actual return type should be platform.UIKit.UIViewController
    // but that type is not available under commonMain
    fun createWordScreen(): Any
}
val LocalWordScreenProvider = staticCompositionLocalOf<WordScreenFactory?> {  null }
@Composable
expect fun WordScreen(modifier: Modifier = Modifier,
                      viewModel: AppViewModel)