package com.example.newsapp.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsapp.R
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.model.Source
import com.example.newsapp.presentation.Dimens.ArticleCarSize
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.newsapp.presentation.Dimens.SmallIconSize
import com.example.newsapp.ui.theme.NewsAppTheme

@Composable
fun ArticleCard(
    article: Article,
    onclick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.clickable { onclick() }

    ) {
        val context = LocalContext.current
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(article.urlToImage)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(ArticleCarSize)
                .clip(MaterialTheme.shapes.medium)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCarSize)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    tint = colorResource(id = R.color.body),
                    modifier = Modifier.size(SmallIconSize)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    NewsAppTheme {
        ArticleCard(
            article = Article(
                author = "Manish Singh",
                content = "In a research note, HSBC estimates that the Indian edtech giant Byju’s, once valued at \$22 billion, is now worth nothing. The write-down in its estimation makes Byju’s one of the most spectacular sta… [+2032 chars]",
                description = "In a research note, HSBC estimates that the Indian edtech giant Byju's, once valued at \$22 billion, is now worth nothing. HSBC estimates that the Indian edtech giant Byju's, once valued at \$22 billion, is now worth nothing.",
                publishedAt = "2024-06-07T02:00:49Z",
                source = Source(id = "techcrunch", name = "TechCrunch"),
                title = "HSBC believes that \$22 billion Byju’s is now worth zero | TechCrunch",
                url = "\"https://techcrunch.com/2024/06/06/hsbc-believes-indian-edtech-byjus-currently-worth-zero/",
                urlToImage = "\"https://techcrunch.com/wp-content/uploads/2023/06/GettyImages-1257740205.jpg?resize=1200,800"
            ), onclick = { /*TODO*/ })
    }
}