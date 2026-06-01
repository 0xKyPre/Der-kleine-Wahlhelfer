package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer

import android.os.Bundle
import androidx.lifecycle.viewmodel.compose.viewModel
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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

        val db = AppDatabase.get(this)
        val repository = PartyRepository(db.partyDao())

        setContent {
            val viewModel: PartyViewModel = viewModel(
                factory = PartyViewModelFactory(repository)
            )

            val parties by viewModel.parties.collectAsStateWithLifecycle()

            LaunchedEffect(Unit) {
                val defaultParties = listOf(
                    Party("SPÖ", "Sozialdemokratische Partei Österreichs", 0),
                    Party("ÖVP", "Österreichische Volkspartei", 0),
                    Party("FPÖ", "Feiheitliche Partei Österreichs", 0),
                    Party("Grüne", "Die Grünen", 0),
                    Party("NEOS", "NEOS", 0)
                )
                defaultParties.forEach { repository.insertParty(it) }
            }

            TestWMCAndroidderkleineWahlhelferTheme {
                val backStack = rememberNavBackStack(Home)

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavDisplay(
                        backStack = backStack,
                        onBack = {
                            if (backStack.size > 1) {
                                backStack.removeAt(backStack.size - 1)
                            }
                        },
                        modifier = Modifier.padding(innerPadding),
                        entryProvider = entryProvider {
                            entry<Home> { _ ->
                                HomeScreen(
                                    onAboutClick = {
                                        backStack.add(About)
                                    },
                                    onOverviewClick = {
                                        backStack.add(Overview)
                                    },
                                )
                            }

                            entry<About> { _ ->
                                AboutScreen(
                                    onClickBack = {
                                        if (backStack.size > 1) {
                                            backStack.removeAt(backStack.size - 1)
                                        }
                                    }
                                )
                            }

                            entry<Overview> { _ ->
                                OverviewScreen(
                                    parties = parties,
                                    onAboutClick = {
                                        backStack.add(About)
                                    },
                                    onHomeClick = {
                                        backStack.add(Home)
                                    },
                                    onClearAllClick = {
                                        viewModel.clearAllVotes()
                                    },
                                    onPartyClick = { party ->
                                        backStack.add(
                                            Count(
                                                partyCode = party.code
                                            )
                                        )
                                    }
                                )
                            }

                            entry<Count> { key ->

                                val party = parties.find {
                                    it.code == key.partyCode
                                } ?: return@entry

                                CountScreen(
                                    party = party,
                                    onAboutClick = { backStack.add(About) },
                                    onHomeClick = { backStack.add(Home) },
                                    onVoteLetterSubmitted = { p, amount ->

                                        viewModel.addVotes(
                                            party = p,
                                            amount = amount
                                        )

                                        if (backStack.isNotEmpty() && backStack.last() is Count) {
                                            backStack.removeAt(backStack.size - 1)
                                        }
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
