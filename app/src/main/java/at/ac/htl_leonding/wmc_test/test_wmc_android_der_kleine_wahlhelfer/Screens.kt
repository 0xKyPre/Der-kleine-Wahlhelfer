package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer

import android.text.Layout
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun HomeScreen(
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
            text = "Welcome to Vote-Helper",
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onAboutClick) {
            Row(
                modifier = Modifier.width(200.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "icon",
                    tint = MaterialTheme.colorScheme.surface,
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text("Go to About")
            }
        }

        Button(onClick = onCounterClick) {
            Row(
                modifier = Modifier.width(200.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "icon",
                    tint = MaterialTheme.colorScheme.surface,
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text("Go to Counter")
            }
        }

        Button(onClick = onOverviewClick) {
            Row(
                modifier = Modifier.width(200.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "icon",
                    tint = MaterialTheme.colorScheme.surface,
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text("Go to Overview")
            }
        }
    }
}
@Composable
fun CountScreen(
    title: String,
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
                        if(counter > 0){
                            counter--;
                        }
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
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopNavBar(onAboutClick, onHomeClick)

        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = "Overview - PDSÖ",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "$totalAmountOfVotes Votes"
            )
        }
    }
}

@Composable
fun AboutScreen(
    title: String,
    onClickBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Button(
                onClick = onClickBack,
                modifier = Modifier.size(40.dp),
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Text(
                text = title,
                fontSize = 40.sp,
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "The App",
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "This is an opensource vote-helper app. This app can count up AND down. And you can navigate",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceContainer)
                    .padding(10.dp)
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Contributors",
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            ContributorCard(
                "Kylian Preining",
                "Android Developer",
                R.drawable.mycelium
            )

            Spacer(modifier = Modifier.height(10.dp))

            ContributorCard(
                "Android Studio",
                "Android IDE",
                R.drawable.warp
            )
        }
    }
}

@Composable
fun License() {
    Text(
        ""
    )
}

@Composable
fun ContributorCard(
    name: String,
    description: String,
    image: Int
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "icon",
            Modifier.height(80.dp)
        )
        Column(

        ) {
            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = description,
                fontSize = 15.sp,
                fontWeight = FontWeight.Light
            )
        }
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
            "About",
            {}
        )
    }
}