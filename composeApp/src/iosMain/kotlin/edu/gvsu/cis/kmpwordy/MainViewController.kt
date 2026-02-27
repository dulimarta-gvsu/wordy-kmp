package edu.gvsu.cis.kmpwordy

import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController(factory: WordScreenFactory) =
    ComposeUIViewController {
        CompositionLocalProvider(LocalWordScreenProvider provides factory) {
            App()
        }
    }