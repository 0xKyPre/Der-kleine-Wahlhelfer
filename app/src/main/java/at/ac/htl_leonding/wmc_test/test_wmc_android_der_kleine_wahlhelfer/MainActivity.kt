package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.theme.TestWMCAndroidderkleineWahlhelferTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.screens.AboutScreen
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.screens.CountScreen
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.screens.HomeScreen
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.screens.OverviewScreen

val parties = listOf(
    "PDSÖ",
    "SPÖ",
    "ÖVP",
    "FPÖ",
    "Grüne",
    "NEOS"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestWMCAndroidderkleineWahlhelferTheme {
                val backStack = rememberNavBackStack(Home)
                var totalCount by rememberSaveable { mutableStateOf(0) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavDisplay(
                        backStack = backStack,
                        onBack = { backStack.removeLastOrNull() },
                        modifier = Modifier.padding(innerPadding),
                        entryProvider = entryProvider {
                            entry<Home> { key ->
                                HomeScreen(
                                    onAboutClick = {
                                        backStack.add(About)
                                    },
                                    onCounterClick = {
                                        backStack.add(Count)
                                    },
                                    onOverviewClick = {
                                        backStack.add(Overview(amountOfVotes = totalCount))
                                    },
                                )
                            }

                            entry<About> { key ->
                                AboutScreen(
                                    onClickBack = {
                                        backStack.removeLastOrNull()
                                    }
                                )
                            }

                            entry<Overview> { key ->
                                OverviewScreen(
                                    totalAmountOfVotes = totalCount,
                                    parties = parties,
                                    onAboutClick = {
                                        backStack.add(About)
                                    },
                                    onHomeClick = {
                                        backStack.add(Home)
                                    },
                                    onClickBack = {
                                        backStack.add(Count)
                                    }
                                )
                            }

                            entry<Count> { key ->
                                CountScreen(
                                    onAboutClick = {
                                        backStack.add(About)
                                    },
                                    onHomeClick = {
                                        backStack.add(Home)
                                    },
                                    onVoteLetterSubmittet = { amountOfVotes ->
                                        totalCount += amountOfVotes
                                        backStack.add(Overview(totalCount))
                                    },
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}