package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color

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
    modifier: Modifier = Modifier,
    onAboutClick: () -> Unit,
    onHomeClick: () -> Unit,
    onVoteLetterSubmittet: (Int) -> Unit
) {
    var counter by remember { mutableStateOf(value = 0) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopNavBar(onAboutClick, onHomeClick)

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Amount of votes",
                fontSize = 30.sp
            )

            Spacer(Modifier.height(40.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    onClick = {
                        counter--;
                    }
                ) {
                    Text(
                        "-1"
                    )
                }

                Spacer(Modifier.width(10.dp))

                Text(
                    text = "$counter",
                    fontSize = 20.sp
                )

                Spacer(Modifier.width(10.dp))

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

            Button(
                onClick = { onVoteLetterSubmittet(counter) }
            ) {
                Text(
                    "Submit"
                )
            }
        }
    }
}

@Composable
fun OverviewScreen(
    totalAmountOfVotes: Int,
    onAboutClick: () -> Unit,
    onHomeClick:() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopNavBar(onAboutClick, onHomeClick)

        Text("Overview")

        Text("$totalAmountOfVotes")
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

@Composable
fun TopNavBar(
    onAboutClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    val aboutIcon = Icons.Default.Info;
    val homeIcon = Icons.Default.Home;

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Button(
            onClick = onHomeClick,
            modifier = Modifier.size(40.dp),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                imageVector = homeIcon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Button(
            onClick = onAboutClick,
            modifier = Modifier.size(40.dp),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(
                imageVector = aboutIcon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
            )
        }
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
            "Counter",
            Modifier,
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
fun OverviewScreenPreview() {
    MaterialTheme {
        OverviewScreen(10, {}, {})
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