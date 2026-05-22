package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.entities.Party
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.components.TopNavBar

@Composable
fun OverviewScreen(
    parties: List<Party>,
    onAboutClick: () -> Unit,
    onHomeClick: () -> Unit,
    onClickBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        TopNavBar(onAboutClick, onHomeClick)

        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
                Text(
                text = "Overview",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            items(parties) { party ->
                PartyCard(
                    partyCode = party.code,
                    amountOfVotes = party.currentVotes
                )
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
            }
        }

        Button(
            onClick = onClickBack,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .width(200.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    "Back to Counter"
                )
            }
        }
    }
}

@Composable
fun PartyCard(
    partyCode: String,
    amountOfVotes: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row (
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = partyCode,
                modifier = Modifier.padding(10.dp)
            )

            Text(
                "$amountOfVotes Votes"
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun OverviewScreenPreview() {
    val previewParties = listOf(
        Party(
            code = "SPÖ",
            name = "Sozialdemokratische Partei Österreichs",
            currentVotes = 123
        ),
        Party(
            code = "ÖVP",
            name = "Österreichische Volkspartei",
            currentVotes = 95
        ),
        Party(
            code = "FPÖ",
            name = "Freiheitliche Partei Österreichs",
            currentVotes = 76
        )
    )

    MaterialTheme {
        OverviewScreen(parties = previewParties, {}, {}, {})
    }
}