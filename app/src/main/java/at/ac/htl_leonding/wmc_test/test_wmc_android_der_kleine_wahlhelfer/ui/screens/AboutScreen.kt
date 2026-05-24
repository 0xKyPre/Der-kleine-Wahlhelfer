package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.R
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.components.ContributorCard

@Composable
fun AboutScreen(
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
                text = "About",
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
                Icons.Default.AccountCircle
            )

            Spacer(modifier = Modifier.height(10.dp))

            ContributorCard(
                "Android Studio",
                "Android IDE",
                Icons.Default.Build
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun AboutScreenPreview() {
    MaterialTheme {
        AboutScreen(
            {}
        )
    }
}