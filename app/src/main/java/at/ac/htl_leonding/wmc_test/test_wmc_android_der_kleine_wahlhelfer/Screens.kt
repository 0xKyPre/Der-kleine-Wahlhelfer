package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    title: String,
    onAboutClick: () -> Unit,
    onCounterClick: () -> Unit,
    onOverviewClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            title,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onAboutClick) {
            Text("Go to About")
        }

        Button(onClick = onCounterClick) {
            Text("Go to Counter")
        }

        Button(onClick = onOverviewClick) {
            Text("Go to Overview")
        }
    }
}

@Composable
fun CountScreen(
    title: String,
    modifier: Modifier = Modifier
) {
    var counter by remember { mutableStateOf(value = 0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text("Amount of votes")

        Text("$counter")

        Button(
            onClick = {
                counter++;
            }
        ) {
            Text(
                "+1"
            )
        }
    }
}

@Composable
fun OverviewScreen(
    title: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text("Overview")
    }
}

@Composable
fun AboutScreen(
    title: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text("About: $title")
    }
}


// -------------------------------------------------------------
// Previews
// -------------------------------------------------------------

@Preview(
    showBackground = true
)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            Modifier,
            "Home",
            {},
            {},
            {}
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CountScreenPreview() {
    MaterialTheme {
        CountScreen(
            "Counter"
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun OverviewScreenPreview() {
    MaterialTheme {
        OverviewScreen("")
    }
}

@Preview(
    showBackground = true
)
@Composable
fun AboutScreenPreview() {
    MaterialTheme {
        AboutScreen(
            "title"
        )
    }
}