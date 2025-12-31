package com.example.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun NewsItem(article: HomeItem) {
      Column(
          modifier = Modifier
              .background(Color.White)
              .padding(16.dp)
              .fillMaxWidth()
      ){
          Image(
              rememberAsyncImagePainter(model = article.urlToImage),
              contentDescription = null,
              modifier = Modifier.fillMaxWidth()
                  .size(200.dp)
          )

          Spacer(modifier = Modifier.height(8.dp))

          Text(
              text = article.title?:"no title",
              fontSize = 24.sp,
              color = Color.Black,
              overflow = TextOverflow.Ellipsis,
          )


          HorizontalDivider(
              modifier = Modifier.padding(vertical = 8.dp),
              thickness = 1.dp,
              color = MaterialTheme.colorScheme.outlineVariant
          )

          Spacer(modifier = Modifier.height(2.dp))

          Text(
              text = article.description?:"No Description",
              fontSize = 18.sp,
              color = Color.Black,
              overflow = TextOverflow.Ellipsis,
          )



          Spacer(modifier = Modifier.height(4.dp))

          ArticleLinkText(article.url)

          Spacer(modifier = Modifier.height (10.dp))
          HorizontalDivider(
              modifier = Modifier.padding(vertical = 8.dp),
              thickness = 2.dp,
              color = MaterialTheme.colorScheme.outlineVariant
          )

          Row {
              Text(
                  text = "Published At : ",
                  fontSize = 12.sp,
                  color = Color.Black,
              )

              Spacer(modifier = Modifier.width(4.dp))

              Text(
                  text =article.publishedAt?:"NOT AVAILABLE",
                  fontSize = 12.sp,
              )
          }
          Spacer(modifier = Modifier.height(4.dp))

          Row {
              Text(
                  text = "Author : ",
                  fontSize = 12.sp,
                  color = Color.Black,
              )
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                  text = article.author?:"NOT AVAILABLE",
                  fontSize = 12.sp,
                  color = Color.Black,
              )
          }
  }
}

@Composable
fun ArticleLinkText(url: String?) {

    val annotatedString = buildAnnotatedString {
        append("Check The Full Article : ")

        if (!url.isNullOrBlank()) {

            withLink(
                LinkAnnotation.Url(
                    url = url,
                    styles = TextLinkStyles(
                        style = SpanStyle(
                            color = Color(0xFF1A73E8),
                            textDecoration = TextDecoration.Underline
                        )
                    )
                )
            ) {
                append(url)
            }
        } else {
            withStyle(style = SpanStyle(color = Color.Red, fontWeight = FontWeight.Medium)) {
                append("NOT AVAILABLE")
            }
        }
    }

    Text(
        text = annotatedString,
        fontSize = 12.sp,
        lineHeight = 18.sp
    )
}