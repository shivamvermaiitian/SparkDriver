package com.example.sparkdriverloginpage.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField1(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    backgroundColor: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.surface,
    contentPadding: PaddingValues = PaddingValues(16.dp)
) {
    Layout(
        content = {
            if (label != null) {
                label()
            }
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = backgroundColor
                )
            )
        },
        modifier = modifier
    ) { measurables, constraints ->
        val padding = contentPadding.calculateTopPadding().toPx()
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        val textFieldPlaceable = placeables.last()
        val labelPlaceable = if (label != null) placeables.first() else null

        layout(constraints.maxWidth, textFieldPlaceable.height + padding.roundToInt()) {
            labelPlaceable?.placeRelative(x = 0, y = 0)
            textFieldPlaceable.placeRelative(x = 0, y = padding.roundToInt())
        }
    }
}

@Composable
fun MyCustomTextFieldExample() {
    var text by remember { mutableStateOf("") }

    CustomOutlinedTextField1(
        value = text,
        onValueChange = { text = it },
        label = { Text("My Custom Label") },
//        backgroundColor = Color.RED,
        contentPadding = PaddingValues(18.dp)
    )
}









//@Composable
//fun MyApp() {
//    MaterialTheme {
//        Surface(modifier = Modifier.fillMaxSize()) {
//            Column(
//                modifier = Modifier.padding(16.dp)
//            ) {
//                MyCustomTextFieldExample()
//            }
//        }
//    }
//}


















//@Composable
//fun CustomScreen(viewModel: StateTestViewModel) {
//    repeat(4) {
//        val name by viewModel.name.observeAsState(initial = "")
//        LayoutOutlineTextField {
//            Text(text = "hello Sir")
////            OutlinedTextField(
////                value = name, onValueChange = {
////                    viewModel.onNameUpdate(it)
////                },
////                singleLine = true,
////                textStyle = TextStyle(
////                    fontSize = 20.sp,
////                ), modifier = Modifier
////                    .fillMaxWidth()
////                    .padding(
////                        start = 20.dp,
////                        end = 20.dp
////                    )
////                    .size(
////                        width = 250.dp,
////                        height = 70.dp
////                    ),
////                shape = RoundedCornerShape(36.dp), colors = TextFieldDefaults.colors()
////            )
//        }
//    }
//}