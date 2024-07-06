package ru.sevastianov.wb.ui.elements

import androidx.compose.foundation.layout.height
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun NavBar(listNavItems:  List<BottomNavItem>, navController: NavHostController) {

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    CompositionLocalProvider(
        LocalRippleTheme provides NoRippleTheme
    ) {
        NavigationBar(
            containerColor = PartyAppTheme.colors.background,
            modifier = Modifier
                .height(64.dp)
                .graphicsLayer { shadowElevation = 100f }
        ) {
            listNavItems.forEachIndexed { index, item ->
                NavigationBarItem(
                    colors = NavigationBarItemDefaults
                        .colors(
                            indicatorColor = Color.Transparent
                        ),
                    selected = selectedItemIndex == index,
                    onClick = {
                        selectedItemIndex = index
                        navController.navigate(item.route)
                    },
                    icon = {
                        BarIcon(
                            imageVector = item.icon,
                            text = item.name,
                            activeNow = selectedItemIndex == index
                        )
                    }
                )
            }
        }
    }
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(
        draggedAlpha = 0.0f,
        focusedAlpha = 0.0f,
        hoveredAlpha = 0.0f,
        pressedAlpha = 0.0f
    )
}