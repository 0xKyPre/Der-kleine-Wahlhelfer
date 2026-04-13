package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer

import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.theme.TestWMCAndroidderkleineWahlhelferTheme
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestWMCAndroidderkleineWahlhelferTheme {
                val backStack = rememberNavBackStack(Home("Home"))
                var totalCount by remember { mutableStateOf(0) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavDisplay(
                        backStack = backStack,
                        onBack = { backStack.removeLastOrNull() },
                        modifier = Modifier.padding(innerPadding),
                        entryProvider = entryProvider {
                            entry<Home> { key ->
                                HomeScreen(
                                    title = key.title,
                                    onAboutClick = {
                                        backStack.add(About("About"))
                                    },
                                    onCounterClick = {
                                        backStack.add(Count("Counter"))
                                    },
                                    onOverviewClick = {
                                        backStack.add(Overview(amountOfVotes = totalCount))
                                    },
                                )
                            }

                            entry<About> { key ->
                                AboutScreen(
                                    title = key.title,
                                    onClickBack = {
                                        backStack.removeLastOrNull()
                                    }
                                )
                            }

                            entry<Overview> { key ->
                                OverviewScreen(
                                    totalAmountOfVotes = totalCount,
                                    onAboutClick = {
                                        backStack.add(About("About"))
                                    },
                                    onHomeClick = {
                                        backStack.add(Home("Home"))
                                    }
                                )
                            }

                            entry<Count> { key ->
                                CountScreen(
                                    title = key.title,
                                    modifier = Modifier,
                                    onAboutClick = {
                                        backStack.add(About("About"))
                                    },
                                    onHomeClick = {
                                        backStack.add(Home("Home"))
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