package edu.gvsu.cis.kmpwordy

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController
import edu.gvsu.cis.kmpwordy.ui.LocalWordScreenProvider
import edu.gvsu.cis.kmpwordy.ui.WordScreenFactory

fun MainViewController(factory: WordScreenFactory) =
    ComposeUIViewController {
        CompositionLocalProvider(LocalWordScreenProvider provides factory) {
            App()
        }
    }