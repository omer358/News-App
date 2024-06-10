package com.example.newsapp.presentation.detials

import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsapp.R
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.model.Source
import com.example.newsapp.presentation.Dimens.ArticleImageHeight
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.newsapp.presentation.detials.components.DetailsTopBar
import com.example.newsapp.ui.theme.NewsAppTheme

@Composable
fun DetailsScreen(
    article: Article,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit,
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        DetailsTopBar(
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = Uri.parse(article.url)
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.type = "text/plain"
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                }
            },
            onBookmarkClicked = {
                event(DetailsEvent.SaveArticles)
            },
            onBackClicked = {
                navigateUp()
            }
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = MediumPadding1,
                end = MediumPadding1,
                top = MediumPadding1
            )
        ) {
            item {
                AsyncImage(
                    model = ImageRequest
                        .Builder(context = context)
                        .data(article.urlToImage)
                        .build(),
                    contentDescription = "Article Image for Details Screen",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageHeight)
                        .clip(MaterialTheme.shapes.medium)
                )
                Spacer(modifier = Modifier.height(MediumPadding1))
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(id = R.color.text_title)
                )
                Text(
                    text = article.content,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailsScreenPreview() {
    NewsAppTheme {
        DetailsScreen(article =
        Article(
            author = "Manish Singh",
            content = "In a research note, HSBC estimates that the Indian edtech giant Byju’s, once valued at \$22 billion, is now worth nothing. The write-down in its estimation makes Byju’s one of the most spectacular sta… [+2032 chars]",
            description = "In a research note, HSBC estimates that the Indian edtech giant Byju's, once valued at \$22 billion, is now worth nothing. HSBC estimates that the Indian edtech giant Byju's, once valued at \$22 billion, is now worth nothing.",
            publishedAt = "2024-06-07T02:00:49Z",
            source = Source(id = "techcrunch", name = "TechCrunch"),
            title = "HSBC believes that \$22 billion Byju’s is now worth zero | TechCrunch",
            url = "\"https://techcrunch.com/2024/06/06/hsbc-believes-indian-edtech-byjus-currently-worth-zero/",
            urlToImage = "\"https://techcrunch.com/wp-content/uploads/2023/06/GettyImages-1257740205.jpg?resize=1200,800"
        )
            , event = { /*TODO*/ }) {

        }
    }
}