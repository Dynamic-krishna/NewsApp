
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import data.NewsApiClient
import data.NewsApiClient.client
import data.model.Article
import data.model.News
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jetbrains.skia.Surface
import utilis.Constents
import java.awt.Desktop
import java.net.SocketTimeoutException
import java.net.URI
import java.net.URL

//@Composable
//@Preview
//fun App() {
//    var backgroundColor by remember { mutableStateOf(Color.White) }
//    var displayTest by remember { mutableStateOf("") }
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            ,
//    ) {
//        // Surface with changing background color
//        Surface(
//            modifier = Modifier
//                .fillMaxWidth()
////                .padding(10.dp)
//                .fillMaxHeight(1.0f),
//            color = backgroundColor,
////            shape = RoundedCornerShape(12.dp),
//            elevation = 8.dp
//        ) {
//            // Content inside Surface
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//        Row {
//            // Button to change background color
//            Button(modifier = Modifier
//                .width(150.dp)
//                .fillMaxWidth(0.4f)
//                .fillMaxHeight(0.1f)
//                .padding(1.dp), onClick = {
//                if (backgroundColor == Black) {
//                    backgroundColor = White
//                } else {
//                    backgroundColor = Black
//                }
//            }) {
//                Text("Change Background Color")
//            }
//
//            var textValue by remember { mutableStateOf("") }
//
//            Column(
//                modifier = Modifier.padding(16.dp)
//                    .fillMaxWidth(0.4f)
//            ) {
//                TextField(
//                    value = textValue,
//                    onValueChange = { textValue = it },
//                    label = { Text("Enter text") },
//                )
//                Button(onClick = {
//                    var displayText = "Button clicked!"
//
//                    Text("Display text :$displayText")
//                }, modifier = Modifier
//                    .fillMaxWidth(0.4f)){
//                    Text("Search News")
//                }
//
////                var profile = profile()
////                profile.NewsHeading()
//                // You can add more TextField components here if needed
//            }
//
//        }
//    }
//}

//@Composable
//fun MyComposable() {
//    var isButtonClicked by remember { mutableStateOf(false) }
//    var value by remember { mutableStateOf(0) }
//
//    Surface(
//        color = if (isButtonClicked) Color.Red else MaterialTheme.colors.background,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Button(
//                onClick = {
//                    isButtonClicked = !isButtonClicked
//                    value++
//                },
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text(text = "Click Me")
//            }
//            Text(
//                text = "Value: $value",
//                style = MaterialTheme.typography.body1,
//                modifier = Modifier.padding(16.dp)
//            )
//            AnotherComposable(value = value)
//        }
//    }
//}
//
//@Composable
//fun AnotherComposable(value: Int) {
//    // Do something with the value passed from MyComposable
//    Text(
//        text = "Value from AnotherComposable: $value",
//        style = MaterialTheme.typography.body1,
//        modifier = Modifier.padding(16.dp)
//    )
//}

//@Composable
//fun App() {
//    var backgroundColor by remember { mutableStateOf(Color.White) }
//    var displayText by remember { mutableStateOf("") }
//    var textValue by remember { mutableStateOf("") }
//    var textColor by remember { mutableStateOf(Color.Black) } // State variable for text color
//
//    Box(
//        modifier = Modifier.fillMaxSize()
//    ) {
//    // Surface with changing background color
//        Surface(
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(1.0f),
//            color = backgroundColor,
//            elevation = 8.dp
//        ) {
//        // Content inside Surface
//        }
//
//        Row {
//
//        Spacer(modifier = Modifier.height(16.dp))
//            Column {
//            // Button to change background color
//                Button(
//                    modifier = Modifier
//
//                        .width(150.dp)
//                        .fillMaxWidth(0.4f)
//                        .fillMaxHeight(0.1f)
//                        .padding(1.dp),
//                    onClick = {
//                        backgroundColor = if (backgroundColor == Color.Black) {
//                            Color.White
//                        } else {
//                            Color.Black
//                        }
//
//                        // Change text color when background color changes
//                        textColor = if (backgroundColor == Color.Black) {
//                            Color.White
//                        } else {
//                            Color.Black
//                        }
//                    }
//                ) {
//                    Text("Change Background Color")
//                }
//
//                Column(
//                    modifier = Modifier.padding(5.dp)
//                        .fillMaxWidth(0.3f),
//                ) {
//                    TextField(
//                        value = textValue,
//                        onValueChange = { textValue = it },
//                        label = { Text("Enter text") },
//                        textStyle = TextStyle(color = textColor) // Apply text color
//                    )
//
//                    Button(
//                        modifier = Modifier
//                            .fillMaxWidth(0.6f)
//                            .padding(2.dp),
//                        onClick = {
//                            // Update the display text when the button is clicked
//                            displayText = textValue
//                        },
//
//                        ) {
//                        Text("Search News", color = textColor) // Apply text color
//                    }
//
//                    // Display the text
//                    Text(" $displayText", color = textColor) // Apply text color
//                }
//            }
//            var profile = profile()
////            Heading
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth(0.8f)
//                    .fillMaxHeight()
//                    .padding(10.dp)
//            ){
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth(1f)
//                        .fillMaxHeight()
//                        .padding(10.dp)
//                ) {                 profile.dataprofile()
//                    profile.dataprofile()
//                    profile.dataprofile() }
//
//            }
//
//        }
//
//
//        }
//    }




//@Composable
//@Preview

//new starting ui configuration
//@Composable
//@Preview
//fun MyUi(){
//    Row {
//        Column {
//            Text("hellow")
//           Text("hwllo friend")
//        }
//        Column {
//            Text("hellow coloum 2")
//            Text("hwllo friend coloum 2")
//        }
//    }
//}

//
//@Preview
//@Composable
//fun MainBody() {
//    var currentColor by remember { mutableStateOf(Color.White) }
//
//    val profile = remember { Profile() }
//
//    Box(
//        modifier = Modifier
//            .padding(2.dp)
//            .fillMaxWidth()
//            .fillMaxHeight()
//            .background(Color.White)
//    ) {
//        Surface(
//            modifier = Modifier
//                .padding(5.dp)
//                .fillMaxWidth(1.0f)
//                .fillMaxHeight(),
//            elevation = 12.dp,
//            shape = RoundedCornerShape(12.dp),
//            color = currentColor
//        ) {
//
//        }
//
//        Row {
//            profile.btn { newColor ->
//                currentColor = newColor
//            }
//
//
//
//            Surface(
//                modifier = Modifier
//                    .padding(5.dp)
//                    .fillMaxWidth()
//                    .fillMaxHeight()
//            ) {}
//        }
//    }
//}


fun main() = application {
    var state = rememberWindowState(
        size = DpSize(600.dp, 500.dp),
        position = WindowPosition(300.dp, 300.dp)
    )
    val icon: Painter = painterResource("news.png")
    Window(onCloseRequest = ::exitApplication, title = "Express News", state = state, icon = icon) {
//            App()
//        MyUi()
//            var profile = profile()
//            profile.bgchanger()
//        MainBody()
//        MyComposable()
//        var Screenvalue by remember { mutableStateOf(1) }
//        if (Screenvalue == 1) {

//        Creating a navigation to switch screen but rememberNavController function is not importing after adding the dependency
//        NavHost(navController = navController, StartDestination = HomeScreen())
//        val navController= rememberNavController()

        var value by remember { mutableStateOf(1) }
var articles by remember { mutableStateOf(emptyList<Article>()) }
var headerTitle by remember { mutableStateOf("Headlines") }

if (value == 1) {
    HomeScreen(value)
} else {
    newScreen(headerTitle, articles, value)
    value = 1 // Change value when button is clicked
}
}
}

//        }else{
//            var articles by remember { mutableStateOf(emptyList<Article>()) }
//            var headerTitle by remember { mutableStateOf("Headlines") }
//            newScreen(headers)
//        }

//    } }

//Search news if value is empty then
//fun openURL(uri: URI) {
//    val desktop = Desktop.getDesktop()
//    desktop.browse(uri)
//}

fun loadPicture(url:String){
    try {
        org.jetbrains.skia.Image.makeFromEncoded(URL(url).readBytes())
            .toComposeImageBitmap()
    }catch (e:Exception){
        println("Error of loading url image ${e.message}")
    }
}



@Composable
@Preview()
fun HomeScreen(value:Int) {
    var ReadColor by remember { mutableStateOf(Color.White) }
    var searchInput by remember { mutableStateOf("") }
    var articles by remember { mutableStateOf(emptyList<Article>()) }
    var headerTitle by remember { mutableStateOf("Headlines") }
    var Screenvalue by remember { mutableStateOf(1) }



    val scope = rememberCoroutineScope()

    LaunchedEffect(searchInput){
        scope.launch {
            try {
                val newsData = if (searchInput.isNotEmpty()){
                    NewsApiClient.getSearchedNews(searchInput)
//                    NewsApiClient.getTopHeadlines()
                }else{
                    NewsApiClient.getTopHeadlines()
                }
                articles = newsData.articles
            }catch (e: ClientRequestException){
                println("Error fetching data : ${e.message}")
            }
        }
    }

    Row {

        Surface(
            modifier = Modifier
                .fillMaxWidth(0.2f)
//            .wrapContentWidth()
                .fillMaxHeight()
                .padding(top = 5.dp, start = 5.dp, end = 5.dp)
//            .background(ReadColor)
            ,
            elevation = 8.dp,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 18.dp),
            color = if (ReadColor != Black) White else Black
        ) {
            Column(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
            ) {
                val bitmap = useResource("news.png"){
                    loadImageBitmap(it)
                }

                Image(bitmap,"Logo", modifier = Modifier.width(100.dp))
                Spacer(modifier = Modifier.padding(18.dp))

                Button(onClick = { if (ReadColor != Black) ReadColor = Black else ReadColor = White }) {
                    Text(text = "BG Changer")
                }
//            making Input button
                TextField(modifier = Modifier. fillMaxWidth()
                    .padding(2.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = if (ReadColor != Color.Black) Color.Black else Color.White,
                        backgroundColor = if (ReadColor != Color.Black) Color.White else Color.Black
                    )
                    ,value = searchInput,
                    onValueChange = {
                            newText -> searchInput = newText},
                    label = {Text(color = if (ReadColor != Color.Black) Color.Black else Color.White, text = "Search your News Topic")},
                )
//                if searchinput is not empty search the related news or is it is false then search top news
//                if (searchInput.isNotEmpty()){
//                    getSearchedNews(searchInput)
//                }else{
//                    getTopHeadlines()
//                }

                Text(
                    color = if (ReadColor != Color.Black) Color.Black else Color.White,
                    text = "Your search News is related To :- $searchInput")
            }

        }

        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(top = 5.dp, start = 5.dp, end = 5.dp)
//            .background(ReadColor)
            ,
            elevation = 8.dp,
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 18.dp),
            color = if (ReadColor != Black) White else Black)
        {
//            News Article display section
            NewsDisplay(headerTitle, articles,ReadColor,value)

        }

    }
}
@Composable
fun NewsDisplay(headerTitle: String, articles: List<Article>,ReadColor: Any,value: Int) {
    var value = value

    if (articles.isNotEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize().background(if (ReadColor != Black) White else Black)
                .padding(18.dp)
        ) {
            Text(
                text = headerTitle,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = if (ReadColor != Black) Black else White
            )
            Spacer(Modifier.padding(4.dp)
                .background(if (ReadColor != Black) Black else White))
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 300.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(articles) {
                    Card(elevation = 8.dp, shape = RoundedCornerShape(18.dp),modifier = Modifier.width(400.dp)
                        .height(200.dp).padding(8.dp)  .clickable{

                            value = 2
                            main()
//                            again fail to create my news into new window
//                            newScreen(it.title,it.content.toString())

//opening new window to display the news
//                                Surface(
////                                    color = Color.White,
////                                    modifier = Modifier.fillMaxSize()
////                                ) {
////                                    Column(
////                                        modifier = Modifier.fillMaxSize().padding(16.dp),
////                                        horizontalAlignment = Alignment.CenterHorizontally,
////                                        verticalArrangement = Arrangement.Center
////                                    ) {
////                                        Text(
////                                            text = "New Screen",
////                                            fontSize = 24.sp,
////                                            modifier = Modifier.wrapContentSize()
////                                        )
////                                        Button(
////                                            onClick = { /* Handle button click */ },
////                                            modifier = Modifier.padding(top = 16.dp)
////                                        ) {
////                                            Text(text = "Back to Main")
////                                        }
////                                    }
////                                }
////                            if Click on the news then it will open into the browser
//                            if (it.url.isNullOrEmpty()) {
////                                openURL(URI(it.url))
//                                val desktop = Desktop.getDesktop()
//                                desktop.browse(URI(it.url))
//                            }

                        }
                    )
                    {
                        Box {
                            var bitmap = useResource("no_image.png") {
                                loadImageBitmap(it)
                            }

                            if (it.urlToImage.isNullOrEmpty()) {
                                Image(
                                    bitmap, "no Image available",
                                    modifier = Modifier.size(100.dp).align(Alignment.TopCenter),
                                    contentScale = ContentScale.Crop
                                )
                            } else {
//                                Encounter an error
//                                Image(loadPicture(it.urlToImage),
//                                    "news thumbnail",
//                                    contentScale = ContentScale.Crop
//                                )
                            }
                            Column(
                                modifier = Modifier.align(Alignment.BottomStart)
                                    .background(if (ReadColor != Black) White else Black).padding(12.dp)
                            ) {
                                Text(
                                    it.title ?: "",
                                    color = if (ReadColor != Black) Black else White,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.padding(2.dp))
                                Text(
                                    it.content ?: "",
                                    color = if (ReadColor != Black) Black else White,
                                    fontWeight = FontWeight.ExtraLight,
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize().background(if (ReadColor != Black) White else Black),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Loading...",
                color = if (ReadColor != Black) Black else White)
        }
    }

}
//@Composable
//fun newScreen(HeadingTitle: String, articles: List<Article>,value: Int) {
//
//    var value = value
//    Surface(
//        color = Color.White,
//        modifier = Modifier.fillMaxSize().padding(top = 12.dp, start = 12.dp),
//        elevation = 12.dp
//    ){
//
//        Column(
//            modifier = Modifier.fillMaxSize().padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ){
////            Heading section
//            Text(modifier = Modifier.padding(12.dp),text = "Heading :- $HeadingTitle")
////            About Page Description
//            Text(modifier = Modifier.padding(12.dp), text = "With Good Day Today specail news ${Article}")
//
//            Button(onClick = { value = 1 }) {
//                Text(text = "Go Back to HomeScreen")
//            }
//
//        }
//    }
//}

@Composable
fun newScreen(headingTitle: String, articles: List<Article>, value: Int) {

    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize().padding(top = 12.dp, start = 12.dp),
        elevation = 12.dp
    ){

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            // Heading section
            Text(modifier = Modifier.padding(12.dp), text = "Heading :- $headingTitle")

            // Display article titles
            articles.forEach { article ->
                Text(modifier = Modifier.padding(12.dp), text = article.title)
            }

            Button(onClick = { /* Navigate back to HomeScreen */ }) {
                Text(text = "Go Back to HomeScreen")
            }

        }
    }
}




