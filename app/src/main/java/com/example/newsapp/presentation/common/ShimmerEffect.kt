package com.example.newsapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapp.R
import com.example.newsapp.presentation.Dimens
import com.example.newsapp.ui.theme.NewsAppTheme

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition(label = "InfiniteTransition")
    val alpha = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ), label = "alpha transition"
    ).value
    background(color =  colorResource(id = R.color.shimmer).copy(alpha)
    )
}

@Composable
fun ArticleShimmerEffect(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier

    ) {
        val context = LocalContext.current
        Box(
            modifier = Modifier
                .size(Dimens.ArticleCarSize)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = Dimens.ExtraSmallPadding)
                .height(Dimens.ArticleCarSize)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(horizontal = Dimens.MediumPadding2)
                    .shimmerEffect()
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(15.dp)
                        .padding(horizontal = Dimens.MediumPadding2)
                        .shimmerEffect()
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Preview( uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ArticleShimmerEffectPreview() {
    NewsAppTheme {
        ArticleShimmerEffect()
    }
}