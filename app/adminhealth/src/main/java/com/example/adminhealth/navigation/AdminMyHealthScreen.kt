package com.example.adminhealth.navigation

import androidx.navigation.NamedNavArgument

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments =
        navArguments.filter { it.argument.defaultValue == null }.takeIf { it.isNotEmpty() }
            ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }.orEmpty()
    val optionalArguments =
        navArguments.filter { it.argument.defaultValue != null }.takeIf { it.isNotEmpty() }
            ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }.orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}

sealed class AdminMyHealthScreen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    val name = route.appendArguments(navArguments)

    object SplashScreen: AdminMyHealthScreen(route = "SplashScreen")

    object AddDiseaseScreen: AdminMyHealthScreen(route = "AddDiseaseScreen")

    object DocSighUpScreen: AdminMyHealthScreen(route = "DocSighUpScreen")

    object DoctorDashboardScreen: AdminMyHealthScreen(route = "DoctorDashboardScreen")

    object DoctorLoginScreen: AdminMyHealthScreen(route = "DoctorLoginScreen")

    object AddMedicineScreen: AdminMyHealthScreen(route = "AddMedicineScreen")

    object AddTestScreen: AdminMyHealthScreen(route = "AddTestScreen")

    object PharmacyDashboardScreen: AdminMyHealthScreen(route = "PharmacyDashboardScreen")

    object PharmacyLoginScreen: AdminMyHealthScreen(route = "PharmacyLoginScreen")

    object PharmacySignupScreen: AdminMyHealthScreen(route = "PharmacySignupScreen")

    object SignOutScreen: AdminMyHealthScreen(route = "SignOutScreen")
}