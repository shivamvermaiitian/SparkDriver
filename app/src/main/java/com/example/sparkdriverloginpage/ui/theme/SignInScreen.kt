package com.example.sparkdriverloginpage.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
//import com.example.loginpagesparkdriver.R
import com.example.sparkdriverloginpage.R
import kotlinx.coroutines.launch

@Composable
fun SignInScreen(viewModel: StateTestViewModel,username:String,navController: NavHostController) {
//    val name by viewModel.name.observeAsState(initial = "")
    val name by viewModel.name.observeAsState(initial = "")

//    var email by remember {
//        mutableStateOf("")
//    }
//    var password by remember {
//        mutableStateOf("")
//    }
    val password by viewModel.password.observeAsState(initial = "")
//    var passwordVisibility by remember {
//        mutableStateOf(false)
//    }
    val passwordVisibility by viewModel.passwordVisibility.observeAsState(initial = false)
//    var isValid by remember {
//        mutableStateOf(true)
//    }
    val isValidEmailPassword by viewModel.isValidEmailPassword.observeAsState(initial = true)


    val keyboardController= LocalSoftwareKeyboardController.current

    val icon=if (passwordVisibility)
        painterResource(id = R.drawable.baseline_visibility_24)
    else
        painterResource(id = R.drawable.baseline_visibility_off_24)

    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {paddingValues ->

    Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LightBlue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.logosparkdriver),
                    contentDescription = "Login image",
                    modifier = Modifier.size(80.dp)
                )
                Text(text = "Spark Driver", color = Color.White, fontSize = 50.sp)
            }
            Spacer(modifier = Modifier.height(100.dp))
//
//        TextField(value = name, onValueChange ={
//            viewModel.onNameUpdate(it)
//        }, label = {
//            if (username==null){
//                Text(text = "Email")
//            }else{
//                Text(text = username)
//            }
//        } )

//        Log.i("Myscreenlog","is called")
            OutlinedTextField(
                value = name, onValueChange = {
                    viewModel.onNameUpdate(it)
                },
//            placeholder = {
//                if (username==null){
//                Text(text = "Email",fontSize = 20.sp)
//            }else{
//                Text(text = username,fontSize = 20.sp)
//            }
//                          },
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 20.sp,
                )
//            label = {
//        }
                , modifier = Modifier
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
            OutlinedTextField(
                value = password, onValueChange = {
                    viewModel.onPasswordUpdate(it)
                },
                placeholder = { Text("Password", fontSize = 20.sp) },
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 20.sp,
                ), trailingIcon = {
                    IconButton(onClick = {
//                                  passwordVisibility=!passwordVisibility
                        viewModel.passwordVisibilitychange(!passwordVisibility)
                    }) {
                        Icon(
                            painter = icon,
                            contentDescription = "Visibility Icon"
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation(),
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
            if (!isValidEmailPassword) {
                scope.launch {
                    val result = snackbarHostState
                        .showSnackbar(
                            message = "Wrong Email or Password",
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
//                Text(
//                    text = "Invalid password",
//                    color = Color.Red, fontSize = 20.sp,
//                    modifier = Modifier.padding(8.dp)
//                )
            }

            Button(
                onClick = {
//            isValid = isValidCredentials(name,password)
                    keyboardController?.hide()
                    viewModel.isValidEmailPasswordCredentials(name, password)
                    if (isValidEmailPassword) {
//                        navController.navigate(Routes.screenC)
                        //Login Logic
                    }
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
                Text(text = " CONTINUE ", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                modifier = Modifier.clickable { navController.navigate(Routes.screenC) },
                text = "Forgot password?",
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
//        Text(modifier = Modifier.clickable {  }, text = "Sign up", color = Color.White)
            Spacer(modifier = Modifier.height(200.dp))
            Text(modifier = Modifier.clickable { }, text = "Privacy statement", color = Color.White)

        }
    }

}
//private fun isValidCredentials(email: String, password: String): Boolean {
//    val emailPattern = Regex(
//        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
//                "\\@" +
//                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
//                "(" +
//                "\\." +
//                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
//                ")+"
//    )
//    val passwordPattern = Regex("^(?=.*[0–9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
//    return emailPattern.matches(email) && passwordPattern.matches(password)
//}
