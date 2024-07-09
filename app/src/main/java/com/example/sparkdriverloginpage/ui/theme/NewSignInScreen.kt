package com.example.sparkdriverloginpage.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sparkdriverloginpage.R

@Composable
fun NewSignInScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue),
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
        var text by remember { mutableStateOf(TextFieldValue("")) }
        var email by remember {
            mutableStateOf(TextFieldValue(""))
        }
        Spacer(modifier = Modifier.height(10.dp))
//        CustomLayoutOutlinedTextfield(value = email, onValueChange ={
//            email =it
//        },
//            placeholder = "Welcome,Enter Email"
//        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomLayoutButton(onClick = { /*TODO*/ })
        
        
//        CustomOutlinedTextField(
//            value = text,
//            onValueChange = { text = it },
//            placeholder = "ID or Email"
//        )
//        Spacer(modifier = Modifier.height(10.dp))
//
//        CustomButton(
//            onClick = {
//            },
//            text = "CONTINUE"
//        )



//        MyCustomTextField()
//        Spacer(modifier = Modifier.height(50.dp))
//        Row {
//            Image(
//                painter = painterResource(id = R.drawable.logosparkdriver),
//                contentDescription = "Login image",
//                modifier = Modifier.size(80.dp)
//            )
//            Text(text = "Spark Driver", color = Color.White, fontSize = 50.sp)
//        }



    }






}