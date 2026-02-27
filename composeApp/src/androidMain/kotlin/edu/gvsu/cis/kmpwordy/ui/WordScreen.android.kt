package edu.gvsu.cis.kmpwordy.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import edu.gvsu.cis.kmpwordy.AppViewModel
import edu.gvsu.cis.kmpwordy.LetterGroup
import edu.gvsu.cis.kmpwordy.Origin

@Composable
actual fun WordScreen(modifier: Modifier, viewModel: AppViewModel) {
    val stockLetters by viewModel.sourceLetters.collectAsState()
    val arrangedLetters by viewModel.targetLetters.collectAsState()

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(top = 24.dp)
    ) {

        Button(
            modifier = Modifier.align(Alignment.TopCenter),
            onClick = {
                viewModel.selectRandomLetters()
            },
        ) {
            Text("New Game")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LetterGroup(letters = arrangedLetters, groupId = "Top") {
                viewModel.rearrangeLetters(Origin.CenterBox, it.filterNotNull())
            }
            LetterGroup(letters = stockLetters, groupId = "Bottom") {
                viewModel.rearrangeLetters(Origin.Stock, it.filterNotNull())
            }
        }
    }
}

