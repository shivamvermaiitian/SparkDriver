package com.example.sparkdriverloginpage.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CustomOutlinedTextField(
//    value: TextFieldValue,
//    onValueChange: (TextFieldValue) -> Unit,
//    placeholder: String,
//    modifier: Modifier = Modifier,
//    singleLine: Boolean = true,
//    textStyle: TextStyle = TextStyle(fontSize = 20.sp),
//    width: Dp = 250.dp,
//    height: Dp = 70.dp,
//    shape: RoundedCornerShape = RoundedCornerShape(36.dp),
//    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
//        containerColor = Color.White, // Background color
//        unfocusedBorderColor = Color.Gray,
//        focusedBorderColor = MaterialTheme.colorScheme.primary
//    )
//) {
//    OutlinedTextField(
//        value = value,
//        onValueChange = onValueChange,
//        placeholder = { Text(placeholder, fontSize = 20.sp) },
//        singleLine = singleLine,
//        textStyle = textStyle,
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(start = 20.dp, end = 20.dp)
//            .size(width = width, height = height),
//        shape = shape,
//        colors = colors
//    )
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomLayoutOutlinedTextfield(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "ID or Email",
    singleLine: Boolean = true,
    textStyle: TextStyle = TextStyle(fontSize =20.sp ),
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp
        ).size(width = 250.dp, height = 70.dp
        ),
    shape: RoundedCornerShape= RoundedCornerShape(36.dp),
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        containerColor = Color.White,
    )
    ) {
    OutlinedTextField(
        value = value,
        onValueChange =onValueChange,
        placeholder = { Text(text = placeholder, fontSize = 20.sp)},
        modifier = modifier,
        singleLine = singleLine,
        textStyle = textStyle,
        shape = shape,
        colors = colors
    )
}




@Composable
fun CustomLayoutButton(
    onClick: () -> Unit,
    text: String = "CONTINUE",
//    text: String = "CONTINUE",
    containerColor: Color = DarkBlue_Button,
    contentColor: Color = Color.White,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(
            start = 20.dp,
            end = 20.dp
        )
        .size(
            width = 250.dp,
            height = 70.dp
        ),
    shapes: RoundedCornerShape = RoundedCornerShape(36.dp)
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        modifier = modifier,
        shape = shapes
    ) {
        Text(text = text, fontSize =16.sp)
    }
}


//@Composable
//fun CustomButton(
//    onClick: () -> Unit,
//    text: String,
//    modifier: Modifier = Modifier,
//    containerColor: Color = DarkBlue_Button,
//    contentColor: Color = Color.White,
//    width: Dp = 250.dp,
//    height: Dp = 60.dp,
//    shape: RoundedCornerShape = RoundedCornerShape(36.dp)
//) {
//    Button(
//        onClick = onClick,
//        colors = ButtonDefaults.buttonColors(
//            containerColor = containerColor,
//            contentColor = contentColor
//        ),
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(start = 20.dp, end = 20.dp)
//            .size(width = width, height = height),
//        shape = shape
//    ) {
//        Text(text = text, fontSize = 16.sp)
//    }
//}








@Composable
fun MyCustomTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
//        CustomOutlinedTextField(
//            value = text,
//            onValueChange = { text = it },
//            placeholder = "ID or Email"
//        )
    }
}
