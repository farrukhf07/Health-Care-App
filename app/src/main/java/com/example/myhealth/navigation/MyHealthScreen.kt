package com.example.myhealth.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments =
        navArguments.filter { it.argument.defaultValue == null }.takeIf { it.isNotEmpty() }
            ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }.orEmpty()
    val optionalArguments =
        navArguments.filter { it.argument.defaultValue != null }.takeIf { it.isNotEmpty() }
            ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }.orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}

sealed class MyHealthScreen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    val name =route.appendArguments(navArguments)

    object LoginScreen: MyHealthScreen(route = "LoginScreen")

    object SplashScreen: MyHealthScreen(route = "SplashScreen")

    object SignupScreen: MyHealthScreen(route = "SignupScreen")

    object Dashboard: MyHealthScreen(route = "Dashboard")

    object SignoutScreen: MyHealthScreen(route = "SignoutScreen")

    object FindDoctorScreen: MyHealthScreen(route = "FindDoctorScreen")

    object ChatbotScreen: MyHealthScreen(route = "ChatbotScreen")

    object DoctorProfileScreen: MyHealthScreen(route = "DoctorProfileScreen",
        navArguments = listOf(
            navArgument(DestinationArgs.doctor){
                type = NavType.StringType
            }
        )
    )

    object MedicineListScreen: MyHealthScreen(route = "MedicineListScreen")

    object MedicineDetailScreen: MyHealthScreen(route = "MedicineDetailScreen",
        navArguments = listOf(
            navArgument(DestinationArgs.medidicne){
                type = NavType.StringType
            }
        )
    )

    object LabTestScreen: MyHealthScreen(route = "LabTestScreen")

    object LabTestDetailScreen: MyHealthScreen(route = "LabTestDetailScreen",
        navArguments = listOf(
            navArgument(DestinationArgs.test){
                type = NavType.StringType
            }
        )
    )

    object LabTestChughtaiScreen: MyHealthScreen(route = "LabTestChughtaiScreen")

    object LabTestEssaScreen: MyHealthScreen(route = "LabTestEssaScreen")

    object LabTestExcelScreen: MyHealthScreen(route = "LabTestExcelScreen")

    object DiseaseListScreen: MyHealthScreen(route = "DiseaseListScreen")

    object DiseaseDetailScreen: MyHealthScreen(route = "DiseaseDetailScreen",
        navArguments = listOf(
            navArgument(DestinationArgs.disease){
                type = NavType.StringType
            }
        )
    )

    object DiseaseFeverDetailScreen: MyHealthScreen(route = "DiseaseFeverDetailScreen")

    object DiseaseDengueDetailScreen: MyHealthScreen(route = "DiseaseDengueDetailScreen")

    object DiseaseHeartDetailScreen: MyHealthScreen(route = "DiseaseHeartDetailScreen")

    object PatientProfileScreen: MyHealthScreen(route = "PatientProfileScreen")

    object EditProfileScreen: MyHealthScreen(route = "EditProfileScreen")

    object SettingScreen: MyHealthScreen(route = "SettingScreen")

    object ViewCartScreen: MyHealthScreen(route = "ViewCartScreen")
}
