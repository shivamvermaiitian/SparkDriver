package com.example.sparkdriverloginpage.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.sparkdriverloginpage.R

//import com.example.loginpagesparkdriver.R

@Composable
fun ResetPasswordScreen(viewModel: StateTestViewModel,navController: NavHostController){
//    var email by remember {
//        mutableStateOf("")
//    }
    val name by viewModel.name.observeAsState("")
//    var isValid by remember {
//        mutableStateOf(true)
//    }
    val isValid by viewModel.isValid.observeAsState(initial = true)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue),
        verticalArrangement = Arrangement.Center
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Image(painter = painterResource(id = R.drawable.shield), contentDescription ="Shield image", modifier = Modifier
                .size(120.dp)
                .padding(start = 20.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "Recovery Password", color = Color.White,fontSize = 28.sp, modifier = Modifier.padding(
            start = 20.dp
        ))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "A verification code will be sent to your ", color = Color.White, fontSize = 18.sp, modifier = Modifier.padding(start = 20.dp))
        Text(text = "email in order to change your password.", color = Color.White, fontSize = 18.sp, modifier = Modifier.padding(start = 20.dp))
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = name, onValueChange = {
            viewModel.onNameUpdate(it)
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
            shape = RoundedCornerShape(36.dp),colors = TextFieldDefaults.colors()
        )
        Spacer(modifier = Modifier.height(20.dp))
        if (!isValid) {
            Text(
                text = "Invalid email", fontSize = 20.sp,
                color = Color.Red,
                modifier = Modifier
                    .padding(8.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }


        Button(onClick = {
            viewModel.isValidCredentials(name)
            if (isValid) {
//                navController.navigate(Routes.screenB+"/$email")
                // Handle successful login
            }

//            navController.navigate(Routes.screenB+"/$email")
        }, colors = ButtonDefaults.buttonColors(
            containerColor = green,
            contentColor = Color.White
        ), modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp
            )
            .size(
                width = 250.dp,
                height = 65.dp
            ),shape = RoundedCornerShape(36.dp)
        ) {
            Text(text = " CONTINUE ")
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(modifier = Modifier
            .clickable { }
            .align(
                alignment = Alignment.CenterHorizontally
            ) ,text = "Already have a code", color = Color.White)
        Spacer(modifier = Modifier.height(200.dp))


    }

}
//private fun isValidCredentials(email: String): Boolean {
//    val emailPattern = Regex(
//        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
//                "\\@" +
//                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
//                "(" +
//                "\\." +
//                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
//                ")+"
//    )
////    val passwordPattern = Regex("^(?=.*[0–9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$")
//    return emailPattern.matches(email)
//}


