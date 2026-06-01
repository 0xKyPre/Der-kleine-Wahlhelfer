package at.ac.htl_leonding.wmc_test.test_wmc_android_der_kleine_wahlhelfer.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val MyceliumColorScheme = darkColorScheme(
    primary = MyceliumPrimary,
    secondary = MyceliumSecondary,
    tertiary = MyceliumPurple,
    background = MyceliumDark,
    surface = MyceliumSurface,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = MyceliumLight,
    onSurface = MyceliumOnSurface,
    surfaceContainer = MyceliumSurface
)

@Composable
fun TestWMCAndroidderkleineWahlhelferTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = MyceliumColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
