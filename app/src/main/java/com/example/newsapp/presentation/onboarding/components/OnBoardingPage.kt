package com.example.newsapp.presentation.onboarding.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.R
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.newsapp.presentation.Dimens.MediumPadding2
import com.example.newsapp.presentation.onboarding.Page
import com.example.newsapp.presentation.onboarding.pages

@Composable
fun OnBoardingPage(
    page: Page,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = page.image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            text = page.title,
            style = MaterialTheme
                .typography
                .displaySmall.copy(
                    fontWeight = FontWeight.Bold
                ),
            color = colorResource(id = R.color.display_small),
            modifier = Modifier
                .padding(horizontal = MediumPadding2)
        )
        Text(
            text = page.description,
            style = MaterialTheme
                .typography
                .bodyMedium,
            color = colorResource(id = R.color.text_medium),
            modifier = Modifier
                .padding(horizontal = MediumPadding2)
        )
    }
}

@Preview(
    showBackground = true,
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun OnBoardingPagePreview() {
    OnBoardingPage(page = pages.first())
}