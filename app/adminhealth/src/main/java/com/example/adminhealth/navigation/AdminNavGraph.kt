package com.example.adminhealth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.adminhealth.utils.ADMIN_NAV_GRAPH
import com.example.adminhealth.views.screens.SignOutScreen
import com.example.adminhealth.views.screens.doctor.AddDiseaseScreen
import com.example.adminhealth.views.screens.doctor.DocSignUpScreen
import com.example.adminhealth.views.screens.doctor.DoctorDashboardScreen
import com.example.adminhealth.views.screens.doctor.DoctorLoginScreen
import com.example.adminhealth.views.screens.pharmacy.AddMedicineScreen
import com.example.adminhealth.views.screens.pharmacy.AddTestScreen
import com.example.adminhealth.views.screens.pharmacy.PharmacyDashboardScreen
import com.example.adminhealth.views.screens.pharmacy.PharmacyLoginScreen
import com.example.adminhealth.views.screens.pharmacy.PharmacySignUpScreen
import com.example.myhealth.views.screens.SplashLoginScreen

fun NavGraphBuilder.appNavGraph(
    navController: NavController
){
    navigation(
        startDestination = AdminMyHealthScreen.SplashScreen.name,
        route = ADMIN_NAV_GRAPH
    ){
        composable(route = AdminMyHealthScreen.SplashScreen.name) {
            SplashLoginScreen(onDocLogin = {
                                           navController.navigate(AdminMyHealthScreen.DoctorLoginScreen.name)
            }, onPharmLogin = {
                navController.navigate(AdminMyHealthScreen.PharmacyLoginScreen.name)
            }, onDocDashboard = {
                navController.navigate(AdminMyHealthScreen.DoctorDashboardScreen.name){
                    popUpTo(0)
                }
            }, onPharmacyDashboard = {
                navController.navigate(AdminMyHealthScreen.PharmacyDashboardScreen.name){
                    popUpTo(0)
                }
            })
        }

        composable(route = AdminMyHealthScreen.AddDiseaseScreen.name) {
            AddDiseaseScreen(add = {
                navController.popBackStack()
            },
                btnBack = {
                    navController.popBackStack()
                })
        }

        composable(route = AdminMyHealthScreen.DocSighUpScreen.name) {
            DocSignUpScreen(onLogin = {
                                      navController.popBackStack()
            })
        }

        composable(route = AdminMyHealthScreen.DoctorDashboardScreen.name) {
            DoctorDashboardScreen(addDisease = {
                navController.navigate(AdminMyHealthScreen.AddDiseaseScreen.name)
            },
                onSignout = {
                    navController.navigate(AdminMyHealthScreen.SignOutScreen.name)
                })
        }

        composable(route = AdminMyHealthScreen.DoctorLoginScreen.name) {
            DoctorLoginScreen(onDocDashboard = {
                                        navController.navigate(AdminMyHealthScreen.DoctorDashboardScreen.name)
            }, doctorSignUp = {
                navController.navigate(AdminMyHealthScreen.DocSighUpScreen.name)
            },
                btnBack = {
                    navController.popBackStack()
                })
        }

        composable(route = AdminMyHealthScreen.AddMedicineScreen.name) {
            AddMedicineScreen(add = {
                navController.popBackStack()
            },
                btnBack = {
                    navController.popBackStack()
                })
        }

        composable(route = AdminMyHealthScreen.AddTestScreen.name) {
            AddTestScreen(add = {
                navController.popBackStack()
            },
                btnBack = {
                    navController.popBackStack()
                })
        }

        composable(route = AdminMyHealthScreen.PharmacyDashboardScreen.name) {
            PharmacyDashboardScreen(addMedicine = {
                                                  navController.navigate(AdminMyHealthScreen.AddMedicineScreen.name)
            }, addTest = {
                navController.navigate(AdminMyHealthScreen.AddTestScreen.name)
            }, onSignout = {
                navController.navigate(AdminMyHealthScreen.SignOutScreen.name)
            })
        }

        composable(route = AdminMyHealthScreen.PharmacyLoginScreen.name) {
            PharmacyLoginScreen(onLogin = {
                                          navController.navigate(AdminMyHealthScreen.PharmacyDashboardScreen.name)
            }, pharmacySignup = {
                navController.navigate(AdminMyHealthScreen.PharmacySignupScreen.name)
            },
                btnBack = {
                    navController.popBackStack()
                })
        }

        composable(route = AdminMyHealthScreen.PharmacySignupScreen.name) {
            PharmacySignUpScreen(onLogin = {
                navController.popBackStack()
            })
        }

        composable(route = AdminMyHealthScreen.SignOutScreen.name) {
            SignOutScreen(onLogin = {
                navController.navigate(AdminMyHealthScreen.SplashScreen.name){
                    popUpTo(0)
                }
            })
        }
    }
}