package com.example.myhealth.views.components
//
//import android.graphics.Color
//import androidx.annotation.DrawableRes
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.BlendMode.Companion.Color
//import androidx.compose.ui.graphics.RectangleShape
//import androidx.compose.ui.graphics.Shape
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import coil.compose.AsyncImagePainter
//import coil.compose.rememberAsyncImagePainter
//import coil.request.CachePolicy
//import coil.request.ImageRequest
//
////Module Level
////
////io.coil-kt:coil-compose:2.2.2
////io.coil-kt:coil-svg:2.2.2
//
//// Component
//data class ImageBorder(
//    val width: Dp = 3.dp,
//    val color: Color,
//    val shape: Shape = RectangleShape // dataclass in model folder
//)
//
//@Composable
//fun SirImageViewLoader(  // in component folder
//    modifier: Modifier = Modifier,
//    imageUrl: String? = null,
//    @DrawableRes drawable: Int? = null,
//    @DrawableRes placeholder: Int? = null,
//    @DrawableRes error: Int? = null,
//    width: Dp = 94.dp,
//    height: Dp = width,
////    backgroundColor: Color = Color.Transparent,    comment by me
//    imageBorder: ImageBorder? = null,
//    isRounded: Boolean = true,
//    imageContentScale: ContentScale = ContentScale.FillBounds,
//    isFillBounds: Boolean = false
//) {
//    var localModifier = modifier.size(width = width, height = height)
//    if (isRounded) localModifier = localModifier.clip(CircleShape)
////    localModifier = localModifier.background(backgroundColor)  comment by me
//
//    if (imageBorder != null) {
//        localModifier = localModifier
//            .border(
//                width = imageBorder.width,
//                color = imageBorder.color,
//                shape = if (isRounded) CircleShape else imageBorder.shape
//            )
//            .clip(if (isRounded) CircleShape else imageBorder.shape)
//    }
//
//    val placeHolderModifier: Modifier
//    if (isFillBounds) {
//        placeHolderModifier = Modifier.size(width = width, height = height)
//    } else {
//        placeHolderModifier = Modifier.size(width = width / 1f, height = height / 1f)
//    }
//    if (drawable != null) {
//        Box(localModifier) {
//            Image(
//                modifier = Modifier.align(Alignment.Center),
//                painter = painterResource(id = drawable),
//                contentScale = ContentScale.Inside,
//                contentDescription = "avatar",
//
//                )
//        }
//        return
//    } else if (imageUrl.isNullOrEmpty()) {
//        Box(localModifier) {
//            SirImagePlaceHolder(
//                modifier = placeHolderModifier.align(Alignment.Center),
//                image = placeholder?.let { painterResource(id = it) }
//            )
//        }
//        return
//    }
//
//    val imagePainter = rememberAsyncImagePainter(
//        model = ImageRequest.Builder(LocalContext.current)
//            .data(imageUrl)
//            .crossfade(true)
//            .memoryCacheKey(imageUrl)
//            .diskCacheKey(imageUrl)
//            .networkCachePolicy(CachePolicy.ENABLED)
//            .diskCachePolicy(CachePolicy.ENABLED)
//            .memoryCachePolicy(CachePolicy.ENABLED)
//            .build(),
//        contentScale = imageContentScale,
//    )
//
//    Box(localModifier) {
//        Image(
//            modifier = Modifier
//                .align(Alignment.Center)
//                .fillMaxSize(),
//            painter = imagePainter,
//            contentScale = imageContentScale,
//            contentDescription = "avatar",
//        )
//        AnimatedVisibility(
//            modifier = Modifier.align(Alignment.Center),
//            visible = when (imagePainter.state) {
//                is AsyncImagePainter.State.Empty,
//                is AsyncImagePainter.State.Success,
//                -> false
//                is AsyncImagePainter.State.Loading,
//                is AsyncImagePainter.State.Error,
//                -> false
//            }
//        ) {
//            val image = if (imagePainter.state is AsyncImagePainter.State.Error) {
//                error?.let { painterResource(id = it) }
//            } else {
//                placeholder?.let { painterResource(id = it) }
//            }
//            SirImagePlaceHolder(
//                modifier = placeHolderModifier.align(Alignment.Center),
//                image = image
//            )
//        }
//    }
//}
//
//@Composable
//private fun SirImagePlaceHolder(modifier: Modifier, image: Painter?) {
//    if (image != null) {
//        Image(
//            modifier = modifier,
//            painter = image,
//            contentScale = ContentScale.FillBounds,
//            contentDescription = "placeholder_error"
//        )
//    }
//}
//
////calling
//ImageViewLoader(
//modifier = Modifier.size(80.dp),
//imageUrl = LoginResponse.getLoginResponseBody()?.userInfo?.picture ?: "",
//placeholder = R.drawable.image_placeholder,
//isRounded = true,
//width = 80.dp
//)