///*
// * Copyright (c) 2023-2024 Compose Cupertino project and open source contributors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *     http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package io.github.alexzhirkevich.cupertino
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberUpdatedState
//import androidx.compose.ui.graphics.Color
//import platform.UIKit.UIColorPickerViewController
//import platform.UIKit.UIColorPickerViewControllerDelegateProtocol
//import platform.darwin.NSObject
//
//@Composable
//@ExperimentalCupertinoApi
//fun CupertinoColorPickerNative(
//    color : Color,
//    onColorChanged : (Color) -> Unit,
//    onDismissRequest : () -> Unit,
//    supportsAlpha : Boolean = true,
//) {
//
//    val updatedOnColorChanged by rememberUpdatedState(onColorChanged)
//    val updatedOnDismissRequest by rememberUpdatedState(onDismissRequest)
//
//    val delegate = remember {
//        ColorPickerDelegate(
//            onColorChanged = {
//                updatedOnColorChanged(it)
//            },
//            onDismissRequest = {
//                updatedOnDismissRequest()
//            }
//        )
//    }
//
//    PresentationController(
//        factory = {
//            UIColorPickerViewController().apply {
//                this.delegate = delegate
//                this.supportsAlpha = supportsAlpha
//            }
//        },
//        update = {
//            selectedColor = color.toUIColor()
//            this.supportsAlpha = supportsAlpha
//        },
//        onDismissRequest = updatedOnDismissRequest,
//        color, supportsAlpha
//    )
//}
//
//private class ColorPickerDelegate(
//    private val onColorChanged: (Color) -> Unit,
//    private val onDismissRequest: () -> Unit
//) : NSObject(), UIColorPickerViewControllerDelegateProtocol {
//    override fun colorPickerViewControllerDidSelectColor(
//        viewController: UIColorPickerViewController
//    ) {
//        onColorChanged(viewController.selectedColor.toComposeColor())
//    }
//
//    override fun colorPickerViewControllerDidFinish(
//        viewController: UIColorPickerViewController
//    ) {
//        onDismissRequest()
//    }
//}