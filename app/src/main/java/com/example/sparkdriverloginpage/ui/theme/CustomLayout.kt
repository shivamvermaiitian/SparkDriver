package com.example.sparkdriverloginpage.ui.theme

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MovableContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LayoutOutlineTextField(
    modifier: Modifier = Modifier,
    content : @Composable ()-> Unit
) {
    Layout(modifier=modifier,
        measurePolicy = { measurables,constraints ->
            val placeable = measurables.map {
                it.measure(constraints)
            }
            layout(width = constraints.maxWidth,
                height = constraints.maxHeight
            ){
                var yPosition=0
                placeable.forEach {placeable ->
                    placeable.place(
                        x=0,
                        y=yPosition
                    )
                    yPosition+=placeable.width
                }

            }

        },content = content
    )

}
















//@Composable
//fun LayoutOutlineTextField(
//    modifier: Modifier = Modifier,
//    content : @Composable ()-> Unit
//) {
//    Layout(modifier=modifier,
//        measurePolicy = { measurables,constraints ->
//            val placeable = measurables.map {
//                it.measure(constraints)
//            }
//            layout(width = constraints.maxWidth,
//                height = constraints.maxHeight
//            ){
//                var yPosition=0
//                placeable.forEach {placeable ->
//                    placeable.place(
//                        x=constraints.maxWidth/4,
//                        y=yPosition
//                    )
//                    yPosition+=placeable.width
//                }
//
//            }
//
//    },content = content
//    )
//
//}






















//@Composable
//fun LayoutOutlinedTextField(
//    modifier: Modifier = Modifier,
//    content: @Composable ()->Unit
//    ) {
//    Layout(modifier=Modifier,
//        measurePolicy = { measurables,constraints ->
//                        val placeable = measurables.map {
//                            it.measure(constraints)
//                        }
//            layout(width = constraints.maxWidth,
//                height = constraints.maxHeight
//                ){
//                placeable.forEach {
//                    placeable ->
//                    placeable.place(x=constraints.maxWidth/2,y=0)
//                }
//            }
//
//    },
//        content = content
//        )
//
//}









//@Composable
//fun LayoutOutlinedTextField(
//    modifier: Modifier=Modifier,
//    content:@Composable ()-> Unit
//){
//    
//}

//@Composable
//fun LayoutOutLineTextField(
//    modifier: Modifier = Modifier,
//    content:@Composable ()-> Unit
//    ) {modifier = Modifier,
//    Layout(measurePolicy = { measurables, constraints ->
//        
//    })
//    
//}