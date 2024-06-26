package com.example.sparkdriverloginpage.ui.theme

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.graphics.fonts.FontStyle
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
//import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.sparkdriverloginpage.R
import kotlinx.coroutines.launch
import org.jetbrains.annotations.ApiStatus.Experimental
// comment for testing

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun DefaultLoginScreen(viewModel: StateTestViewModel,navController: NavHostController) {
//    var showError by remember { mutableStateOf(false) }
//    val snackbarHostState = remember { SnackbarHostState() }
    lateinit var stateTestViewModel: StateTestViewModel
//    private val viewModel by viewModels<MyViewModel>()
    // remember saves data in state change
    // rememberSaveable save data across configuration change
    // Use ViewModel and LiveData Hoist the state for re-usability
    val name by viewModel.name.observeAsState(initial = "")

//    var email by rememberSaveable {
//        mutableStateOf("")
//    }
    val isValid by viewModel.isValid.observeAsState(initial = true)
//    var isValid by remember {
//        mutableStateOf(true)
//    }
    val keyboardController= LocalSoftwareKeyboardController.current
//    val snackbarHostState= remember {
//        SnackbarHostState()
//    }
//    var showError by remember { mutableStateOf(false) }
//    val snackbarHostState = remember { SnackbarHostState() }

    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//        Spacer(modifier = Modifier.height(80.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.logosparkdriver),
                    contentDescription = "Login image",
                    modifier = Modifier.size(80.dp)
                )
                Text(text = "Spark Driver", color = Color.White, fontSize = 50.sp)
            }
            Spacer(modifier = Modifier.height(100.dp))

            OutlinedTextField(
                value = name, onValueChange = {
                    viewModel.onNameUpdate(it)
//            email= isValidEmail(email = email)
                },
                placeholder = { Text("ID or Email", fontSize = 20.sp) },
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 20.sp,
                ),
//            label = {
//            Text(text ="ID or Email",fontSize = 18.sp, fontStyle = androidx.compose.ui.text.font.FontStyle(FontStyle.FONT_SLANT_ITALIC))
//        },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp
                    )
                    .size(
                        width = 250.dp,
                        height = 70.dp
                    ),
                shape = RoundedCornerShape(36.dp), colors = TextFieldDefaults.colors()
            )
            Spacer(modifier = Modifier.height(20.dp))

            if (!isValid) {
//                scope.launch {
//                    snackbarHostState.showSnackbar(
//                        message = "Wrong Email",
//                        actionLabel = "GOT IT",
////                        withDismissAction = true,
//                        duration = SnackbarDuration.Short
//                    )
//
//                }
                scope.launch {
                            val result = snackbarHostState
                                .showSnackbar(
                                    message = "Wrong Email",
                                    actionLabel = "GOT IT",
                                    // Defaults to SnackbarDuration.Short
                                    duration = SnackbarDuration.Indefinite
                                )
                            when (result) {
                                SnackbarResult.ActionPerformed -> {
//                                navController.navigate(Routes.screenC)
                                }

                                SnackbarResult.Dismissed -> {
//                                navController.navigate(Routes.screenC)
                                }
                            }
                }

//                val scope = rememberCoroutineScope()
//                val snackbarHostState = remember { SnackbarHostState() }
//                Scaffold(
//                    snackbarHost = {
//                        SnackbarHost(hostState = snackbarHostState)
//                    },
//                    floatingActionButton = {
//                        scope.launch {
//                            val result = snackbarHostState
//                                .showSnackbar(
//                                    message = "Wrong Email",
//                                    actionLabel = "GOT IT",
//                                    // Defaults to SnackbarDuration.Short
//                                    duration = SnackbarDuration.Indefinite
//                                )
//                            when (result) {
//                                SnackbarResult.ActionPerformed -> {
////                                navController.navigate(Routes.screenA)
//                                    /* Handle snackbar action performed */
//                                }
//
//                                SnackbarResult.Dismissed -> {
////                                navController.navigate(Routes.screenA)
//                                    /* Handle snack bar dismissed */
//                                }
//                            }
//                        }
//                    }
//                ) { contentPadding ->
////                DefaultLoginScreen(viewModel,navController)
//                    // Screen content
//                }
            }
////                    ExtendedFloatingActionButton(
////
////                        text = { Text("Show snackbar") },
////                        icon = { Icon(Icons.Filled.Image, contentDescription = "shivam") },
////                        onClick = {
//////                            scope.launch {
//////                                val result = snackbarHostState
//////                                    .showSnackbar(
//////                                        message = "Snackbar",
//////                                        actionLabel = "Action",
//////                                        // Defaults to SnackbarDuration.Short
//////                                        duration = SnackbarDuration.Indefinite
//////                                    )
//////                                when (result) {
//////                                    SnackbarResult.ActionPerformed -> {
//////                                        /* Handle snackbar action performed */
//////                                    }
//////                                    SnackbarResult.Dismissed -> {
//////                                        /* Handle snackbar dismissed */
//////                                    }
//////                                }
//////                            }
////                        }
////                    )
//                }

//            LaunchedEffect(snackbarHostState) {
//                snackbarHostState.showSnackbar("Wrong Email or Password")
////                showError = false // Reset error state after showing the snackbar
//            }
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.BottomCenter
//            ) {
//                SnackbarHost(hostState = snackbarHostState)
//            }

//            Snackbar(
//                action = {},
//                modifier = Modifier.align(
//                    alignment = Alignment.End
//                )
//                ) {
//                Text("Wrong Email")
//            }
//            Text(
//                text = "Invalid email",
//                color = Color.Red,fontSize = 20.sp,
//                modifier = Modifier
//                    .padding(8.dp)
//                    .align(
//                        alignment = Alignment.CenterHorizontally
//                    )
//            )
//            PopupWindow(
//            )
//            Popup(
//                alignment = Alignment.BottomCenter
//            ) {
//                Box {
//                    Text(text = "Invalid Email")
//                }
//            }

            Button(
                onClick = {
                    keyboardController?.hide()
                    viewModel.isValidCredentials(name)
//            viewModel.isValidUpdate(Patterns.EMAIL_ADDRESS.matcher(name).matches())
//            isValid = isValidCredentials(name)
                    if (isValid) {
                        navController.navigate(Routes.screenB + "/$name")
                        // Handle successful login
                    }
//            navController.navigate(Routes.screenB+"/$email")
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = DarkBlue_Button,
                    contentColor = Color.White
                ), modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp
                    )
                    .size(
                        width = 250.dp,
                        height = 60.dp
                    ), shape = RoundedCornerShape(36.dp)
            ) {
                Text(text = "CONTINUE", fontSize = 16.sp)


//            Text(text = " CONTINUE ",fontSize = 16.sp, fontStyle = FontStyle.FONT_WEIGHT_MIN)
            }
            //
            Spacer(modifier = Modifier.height(40.dp))
//        Text(modifier = Modifier.clickable {  }, text = "SIGN UP", color = Color.White)
            Spacer(modifier = Modifier.height(200.dp))
            Text(modifier = Modifier.clickable { }, text = "Privacy statement", color = Color.White)


        }
    }

}


//fun Text(text: String, fontSize: TextUnit, fontStyle: Int) {
//
//}
//private fun isValidCredentials(email: String): Boolean {
//    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
//}
//VIEW
/*        Regex(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
//    val passwordPattern = Regex("^(?=.*[0–9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
    return emailPattern.matches(email)*/

//@Composable
//fun isValidEmail(email:String):Boolean{
//    val pattern=java.util.regex.Pattern.compile(
//        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
//                "\\@" +
//                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
//                "(" +
//                "\\." +
//                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
//                ")+"
//    )
//    val matcher=pattern.matcher(email)
//    return matcher.matches()
//}

//if (showError) {
//            LaunchedEffect(snackbarHostState) {
//                snackbarHostState.showSnackbar("Wrong Email or Password")
//            }
//        }
//        SnackbarHost(
//            hostState = snackbarHostState,
//            snackbar = { snackbarData ->
//                Snackbar(
//                    action = {
//                        TextButton(onClick = { snackbarHostState.currentSnackbarData?.dismiss() }) {
//                            Text("GOT IT", color = Color.White)
//                        }
//                    },
//                    content = {
//                        Text(snackbarData.message, color = Color.White)
//                    },
//                    modifier = Modifier.padding(8.dp)
//                )
//            },
////            modifier = Modifier.align(alignment = Alignment.BottomCenter)
////            modifier = Modifier.align(Alignment.BottomCenter)
//        )
//@ExperimentalMaterial3Api
//@Composable
//fun CustomSnackbarBar(
//    snackbarHostState: SnackbarHostState,
//    modifier: Modifier=Modifier
//){
//
//}

