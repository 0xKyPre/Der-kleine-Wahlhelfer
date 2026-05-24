package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp

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
    image: ImageVector
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = image,
            contentDescription = "icon",
            modifier = Modifier.size(80.dp),
            tint = MaterialTheme.colorScheme.primary
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
