package com.example.netflixclonecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .verticalScroll(rememberScrollState())
            ){
                TopAppSection()
                NetflixContentChooser()
                FeaturedMovieSection()
                AddMovieList("Watch It Again")
                AddMovieList("Drama Movies")
                AddMovieList("Action Movies")
                AddMovieList("New Release")
                AddMovieList("Watch It Again")
                AddMovieList("Drama Movies")
                AddMovieList("Action Movies")
                AddMovieList("New Release")
            }
        }
    }

    @Composable
    fun TopAppSection(){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.netflix_symbol),
                contentDescription = "netflix_logo",
                modifier = Modifier.size(60.dp)
            )
            Row {
                Image(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "search",
                    modifier = Modifier
                        .padding(end = 11.dp)
                        .size(32.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "profile",
                    modifier = Modifier
                        .padding(end = 6.dp)
                        .size(32.dp)
                )
            }

        }
    }

    @Composable
    fun NetflixContentChooser(){
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(horizontal = 35.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "TV Shows", color = Color.LightGray, fontSize = 16.sp)
            Text(text = "Movies", color = Color.LightGray, fontSize = 16.sp)
            Row{
                Text(text = "Categories", color = Color.LightGray, fontSize = 16.sp)
                Image(painter = painterResource(id = R.drawable.dropdown), contentDescription = "icon_drop")
            }

        }
    }

    @Composable
    fun FeaturedMovieSection(){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.john_wick_4), contentDescription = "Movie",
                modifier = Modifier.size(300.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 50.dp, end = 50.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Action", color = Color.White)
                Text(text = "Adventure", color = Color.White)
                Text(text = "Adult", color = Color.White)
                Text(text = "Hollywood", color = Color.White)
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 80.dp, end = 80.dp),
                horizontalArrangement = Arrangement.SpaceBetween)
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Image(painter = painterResource(id = R.drawable.ic_add), contentDescription = null)
                    Text(text = "My List", color = Color.LightGray)
                }
                Button(onClick = { },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(text = "Play", color = Color.Black, fontSize = 20.sp)
                    
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Image(painter = painterResource(id = R.drawable.ic_info), contentDescription = null)
                    Text(text = "Info", color = Color.LightGray)
                }
            }
        }
    }

    @Composable
    fun AddMovieList(movieType : String){
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .padding(top = 8.dp, start = 5.dp))
        {
            Text(text = movieType, color = Color.LightGray,
                fontSize = 24.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp))
            LazyRow {
                itemsIndexed(getRandomMovieList()) { index, item ->
                    MovieItemUiModel(imageRes = item.image)
                }
            }
        }

    }


    @Composable
    fun MovieItemUiModel(imageRes : Int)
    {
        Image(painter = painterResource(id = imageRes),
            contentDescription = "" ,
            modifier = Modifier
                .width(140.dp)
                .height(200.dp)
        )
    }

    fun getRandomMovieList() : List<MovieItemModel>{
        val listofMovies = mutableListOf<MovieItemModel>()
        listofMovies.add(MovieItemModel(R.drawable.hobs_and_shaw))
        listofMovies.add(MovieItemModel(R.drawable.article_370))
        listofMovies.add(MovieItemModel(R.drawable.john_wick_4))
        listofMovies.add(MovieItemModel(R.drawable.rrr))

        listofMovies.shuffle()
        return listofMovies
    }
    data class MovieItemModel(
        val image : Int
    )

}



