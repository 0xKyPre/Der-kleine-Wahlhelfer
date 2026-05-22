package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
object Home: NavKey

@Serializable
object About: NavKey

@Serializable
object Overview : NavKey

@Serializable
data class Count(
    val partyCode: String
): NavKey