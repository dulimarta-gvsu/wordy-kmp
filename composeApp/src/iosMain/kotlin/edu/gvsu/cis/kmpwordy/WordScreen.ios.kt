package edu.gvsu.cis.kmpwordy

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitViewController
import platform.UIKit.UIViewController

@Composable
actual fun WordScreen(modifier: Modifier, viewModel: AppViewModel) {
    val factory = LocalWordScreenProvider.current

    if (factory != null) {
        val wordScreenView = remember { factory.createWordScreen() as UIViewController }
        UIKitViewController(factory = { wordScreenView },
            modifier = modifier)
    } else {
        Text("No WordScreen factory provided")
    }
}