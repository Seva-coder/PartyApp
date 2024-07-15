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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.sevastianov.wb.ui.theme.PartyAppTheme

@Composable
fun NavBar(listNavItems:  List<BottomNavItem>, navController: NavHostController) {

    CompositionLocalProvider(
        LocalRippleTheme provides NoRippleTheme
    ) {
        NavigationBar(
            containerColor = PartyAppTheme.colors.background,
            modifier = Modifier
                .height(64.dp)
                .graphicsLayer { shadowElevation = 100f }
        ) {
            val navBackStackEntry = navController.currentBackStackEntryAsState().value
            val currentDestination = navBackStackEntry?.destination

            listNavItems.forEach { item ->
                val destination = item.route
                NavigationBarItem(
                    colors = NavigationBarItemDefaults
                        .colors(
                            indicatorColor = Color.Transparent
                        ),
                    selected = currentDestination?.hasRoute(destination::class) ?: false,
                    onClick = {
                        navController.navigate(destination) {
                            popUpTo(destination) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        BarIcon(
                            imageVector = item.icon,
                            text = item.name,
                            activeNow = currentDestination?.hasRoute(item.route::class) ?: false,
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