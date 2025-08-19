package com.example.myhealth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myhealth.utils.APP_NAV_GRAPH
import com.example.myhealth.utils.AUTH
import com.example.myhealth.views.screens.DashboardScreen
import com.example.myhealth.views.screens.DiseaseDengueDetailScreen
import com.example.myhealth.views.screens.DiseaseDetailScreen
import com.example.myhealth.views.screens.DiseaseFeverDetailScreen
import com.example.myhealth.views.screens.DiseaseHeartDetailScreen
import com.example.myhealth.views.screens.DiseaseListScreen
import com.example.myhealth.views.screens.DoctorProfileScreen
import com.example.myhealth.views.screens.EditProfileScreen
import com.example.myhealth.views.screens.FindDoctorScreen
import com.example.myhealth.views.screens.LabTestChughtaiScreen
import com.example.myhealth.views.screens.LabTestDetailScreen
import com.example.myhealth.views.screens.LabTestEssaScreen
import com.example.myhealth.views.screens.LabTestExcelScreen
import com.example.myhealth.views.screens.LabTestScreen
import com.example.myhealth.views.screens.LoginScreen
import com.example.myhealth.views.screens.MedicineDetail
import com.example.myhealth.views.screens.MedicineListScreen
import com.example.myhealth.views.screens.PatientProfileScreen
import com.example.myhealth.views.screens.SettingScreen
import com.example.myhealth.views.screens.SignOutScreen
import com.example.myhealth.views.screens.SignupScreen
import com.example.myhealth.views.screens.SplashScreen
import com.example.myhealth.views.screens.ViewCartScreen
import com.google.gson.Gson
import java.net.URLEncoder


fun NavGraphBuilder.appNavGraph(
    navController: NavController
){
    navigation(
        startDestination = MyHealthScreen.SplashScreen.name,
        route = APP_NAV_GRAPH
    ){
        composable(route = MyHealthScreen.LoginScreen.name) {
            LoginScreen(
                onSignup = {
                    navController.navigate(MyHealthScreen.SignupScreen.name)
                           },
                onDashboard = {
                    navController.navigate(MyHealthScreen.Dashboard.name){
                        popUpTo(0)
                    }
                }
            )
        }

        composable(route = MyHealthScreen.SplashScreen.name) {
            SplashScreen(onLogin = {
                                   navController.navigate(MyHealthScreen.LoginScreen.name){
                                       popUpTo(0)
                                   }
            }, onDashboard = {
                navController.navigate(MyHealthScreen.Dashboard.name){
                    popUpTo(0)
                }
            })
        }

        composable(route = MyHealthScreen.SignupScreen.name) {
            SignupScreen(
                onLogin = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = MyHealthScreen.SignoutScreen.name) {
            SignOutScreen(onLogin = {
                navController.navigate(MyHealthScreen.LoginScreen.name){
                    popUpTo(0) // if click on logout go to login screen if press back close activity
                }
            })
        }

        composable(route = MyHealthScreen.Dashboard.name) {
            DashboardScreen(
                viewAllDisease = {
                                 navController.navigate(MyHealthScreen.DiseaseListScreen.name)
                },
                orderMedicine = {
                                navController.navigate(MyHealthScreen.MedicineListScreen.name)
                },
                findDoc = {
                    navController.navigate(MyHealthScreen.FindDoctorScreen.name)
                },
                labTest = {
                          navController.navigate(MyHealthScreen.LabTestScreen.name)
                },
                fever = {
                        navController.navigate(MyHealthScreen.DiseaseFeverDetailScreen.name)
                },
                dengue = {
                         navController.navigate(MyHealthScreen.DiseaseDengueDetailScreen.name)
                },
                heartAttack = {
                              navController.navigate(MyHealthScreen.DiseaseHeartDetailScreen.name)
                },
                profile = {
                    navController.navigate(MyHealthScreen.PatientProfileScreen.name)
                }
            )
        }

        composable(route = MyHealthScreen.FindDoctorScreen.name) {
            FindDoctorScreen(btnBack = {
                navController.popBackStack()
            },
                docProfile = { doctor->
                             val data = Gson().toJson(doctor)
                    navController.navigate(MyHealthScreen.DoctorProfileScreen.route+"/${URLEncoder.encode(data, "UTF-8")}")
                },
                appointment = {})
        }

        composable(route = MyHealthScreen.DoctorProfileScreen.name) {
            DoctorProfileScreen()
        }

        composable(route = MyHealthScreen.MedicineListScreen.name) {
            MedicineListScreen(btnBack = {
                navController.popBackStack()
            }, onMedicineDetail = { medicine->
                val data = Gson().toJson(medicine)
                navController.navigate(MyHealthScreen.MedicineDetailScreen.route+"/${URLEncoder.encode(data,"UTF-8")}")
            }, addMed = {})
        }

        composable(route = MyHealthScreen.MedicineDetailScreen.name) {
            MedicineDetail(
                btnBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = MyHealthScreen.LabTestScreen.name) {
            LabTestScreen(
                btnBack = {
                          navController.popBackStack()
                },
                chugtaiLabClick = {
                                  navController.navigate(MyHealthScreen.LabTestChughtaiScreen.name)
                },
                essaLabClick = {navController.navigate(MyHealthScreen.LabTestEssaScreen.name)},
                excelLabClick = {navController.navigate(MyHealthScreen.LabTestExcelScreen.name)}
            )
        }

        composable(route = MyHealthScreen.LabTestDetailScreen.name) {
            LabTestDetailScreen(btnBack = {
                navController.popBackStack()
            }
            )
        }

        composable(route = MyHealthScreen.LabTestChughtaiScreen.name) {
            LabTestChughtaiScreen(onTestDetail = {testChughtai->
                val data = Gson().toJson(testChughtai)
                navController.navigate(MyHealthScreen.LabTestDetailScreen.route + "/${URLEncoder.encode(data, "UTF-8")}")
            },
                btnBack = {
                    navController.popBackStack()
                })
        }

        composable(route = MyHealthScreen.LabTestEssaScreen.name) {
            LabTestEssaScreen(onTestDetail = {testEssa->
                val data = Gson().toJson(testEssa)
                navController.navigate(MyHealthScreen.LabTestDetailScreen.route + "/${URLEncoder.encode(data, "UTF-8")}")
            },
                btnBack = {
                    navController.popBackStack()
                })
        }

        composable(route = MyHealthScreen.LabTestExcelScreen.name) {
            LabTestExcelScreen(onTestDetail = {testExcel->
                val data = Gson().toJson(testExcel)
                navController.navigate(MyHealthScreen.LabTestDetailScreen.route + "/${URLEncoder.encode(data, "UTF-8")}")
            },
                btnBack = {
                    navController.popBackStack()
                })
        }

        composable(route = MyHealthScreen.DiseaseListScreen.name) {
            DiseaseListScreen(btnBack = {
                navController.popBackStack()
            },
                onDiseaseDetail = {disease ->
                    val data = Gson().toJson(disease)
                    navController.navigate(MyHealthScreen.DiseaseDetailScreen.route + "/${URLEncoder.encode(data, "UTF-8")}")
                })
        }

        composable(route = MyHealthScreen.DiseaseDetailScreen.name) {
            DiseaseDetailScreen(
                btnBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = MyHealthScreen.DiseaseFeverDetailScreen.name) {
            DiseaseFeverDetailScreen(btnBack = {
                navController.popBackStack()
            })
        }

        composable(route = MyHealthScreen.DiseaseDengueDetailScreen.name) {
            DiseaseDengueDetailScreen(btnBack = {
                navController.popBackStack()
            })
        }

        composable(route = MyHealthScreen.DiseaseHeartDetailScreen.name) {
            DiseaseHeartDetailScreen(btnBack = {
                navController.popBackStack()
            })
        }

        composable(route = MyHealthScreen.PatientProfileScreen.name) {
            PatientProfileScreen(
                editProfile = {
                              navController.navigate(MyHealthScreen.EditProfileScreen.name)
                },
                viewCart = {
                           navController.navigate(MyHealthScreen.ViewCartScreen.name)
                },
                setting = {
                          navController.navigate(MyHealthScreen.SettingScreen.name)
                },
                signOut = {
                    navController.navigate(MyHealthScreen.SignoutScreen.name)
                }
            )
        }

        composable(route = MyHealthScreen.EditProfileScreen.name) {
            EditProfileScreen(
                update = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = MyHealthScreen.SettingScreen.name) {
            SettingScreen(
                update = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = MyHealthScreen.ViewCartScreen.name) {
            ViewCartScreen()
        }
    }
}