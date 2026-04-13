package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class Home(val title: String) : NavKey

@Serializable
data class About(val title: String) : NavKey

@Serializable
data class Overview(
    val amountOfVotes: Int
) : NavKey

@Serializable
data class Count(val title: String) : NavKey