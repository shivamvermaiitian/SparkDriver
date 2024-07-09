package com.example.sparkdriverloginpage

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.example.sparkdriverloginpage.ui.theme.CustomScreen
import com.example.sparkdriverloginpage.ui.theme.DefaultLoginScreen
//import com.example.sparkdriverloginpage.ui.theme.MyApp
import com.example.sparkdriverloginpage.ui.theme.MyCustomTextFieldExample
import com.example.sparkdriverloginpage.ui.theme.NewSignInScreen
import com.example.sparkdriverloginpage.ui.theme.ResetPasswordScreen
import com.example.sparkdriverloginpage.ui.theme.Routes
import com.example.sparkdriverloginpage.ui.theme.SignInScreen
import com.example.sparkdriverloginpage.ui.theme.StateTestViewModel

class MainActivity : ComponentActivity() {
    //    private val viewModel by viewModels<MyViewModel>()
    //    private val myViewModel: MyViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
//        lateinit var stateTestViewModel: StateTestViewModel
//        myViewModel=ViewModelProvider(this).get(myViewModel::class.java)
        super.onCreate(savedInstanceState)
        val viewModel=ViewModelProvider(this)[StateTestViewModel::class.java]
        enableEdgeToEdge()
        setContent {
//            NewSignInScreen()
//            MyCustomTextFieldExample()
//            CustomScreen(viewModel)
//            myViewModel.myData="data is stored"
//            myViewModel=ViewModelProvider(this).get(myViewModel::class.java)
            val navController= rememberNavController()
            NavHost(navController = navController, startDestination = Routes.screenA, builder = {


                composable(Routes.screenA){
                    DefaultLoginScreen(viewModel,navController)
                }


                composable(Routes.screenB+"/{name}"){
                    val name=it.arguments?.getString("email")
                    SignInScreen(viewModel,name?:"Email" , navController)
//                    if (email != null) {
//                        SignInScreen(username = email,navController)
//                    }
                }

                composable(Routes.screenC){
//                    val name=it.arguments?.getString("email")
                    ResetPasswordScreen(viewModel,navController)
                }
            })
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

    }
}
