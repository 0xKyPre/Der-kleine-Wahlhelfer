package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.theme.TestWMCAndroidderkleineWahlhelferTheme
import androidx.compose.runtime.*
import androidx.room.Room
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.AppDatabase
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.entities.Party
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.data.repositories.PartyRepository
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.screens.AboutScreen
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.screens.CountScreen
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.screens.HomeScreen
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.screens.OverviewScreen
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.viewmodel.PartyViewModel
import at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.viewmodel.PartyViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val db = remember {
                Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java,
                    "der-kleine-wahlhelfer-db"
                ).build()
            }

            val repository = remember {
                PartyRepository(db.partyDao())
            }

            val viewModel: PartyViewModel = viewModel(
                factory = PartyViewModelFactory(repository)
            )

            val parties by viewModel.parties.collectAsState()

            LaunchedEffect(Unit) {

                if (parties.isEmpty()) {

                    repository.insertParty(
                        Party(
                            code = "SPÖ",
                            name = "Sozialdemokratische Partei Österreichs",
                            currentVotes = 0
                        )
                    )

                    repository.insertParty(
                        Party(
                            code = "ÖVP",
                            name = "Österreichische Volkspartei",
                            currentVotes = 0
                        )
                    )

                    repository.insertParty(
                        Party(
                            code = "FPÖ",
                            name = "Freiheitliche Partei Österreichs",
                            currentVotes = 0
                        )
                    )

                    repository.insertParty(
                        Party(
                            code = "Grüne",
                            name = "Die Grünen",
                            currentVotes = 0
                        )
                    )

                    repository.insertParty(
                        Party(
                            code = "NEOS",
                            name = "NEOS",
                            currentVotes = 0
                        )
                    )
                }
            }

            TestWMCAndroidderkleineWahlhelferTheme {
                val backStack = rememberNavBackStack(Home)

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
                                        backStack.add(Overview)
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
                                    onVoteLetterSubmittet = { party, amountOfVotes ->

                                        viewModel.addVotes(
                                            party = party,
                                            amount = amountOfVotes
                                        )

                                        backStack.add(Overview)
                                    }
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}