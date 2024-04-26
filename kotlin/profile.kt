import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp

//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//
////import androidx.compose.foundation.Image
////import androidx.compose.foundation.layout.Column
////import androidx.compose.foundation.layout.Row
////import androidx.compose.material.Text
////import androidx.compose.runtime.Composable
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.graphics.ImageBitmap
////import jdk.javadoc.internal.doclets.formats.html.markup.Text
////import javax.imageio.ImageReader
////
////class profile {
////    @Composable
////    fun ArtistCardRow(artist: Artist) {
////        Row(verticalAlignment = Alignment.CenterVertically) {
////            Image(bitmap = artist.image, contentDescription = "Artist image")
////            Column {
////                Text(artist.name)
////                Text(artist.lastSeenOnline)
////            }
////        }
////    }
////
////    fun  previewArtist(){
////        val artist = Artist(
////            image = ImageReader(),
////            name = "John Doe",
////            lastSeenOnline = "Last seen: 2 hours ago"
////        )
////        ArtistCardRow(artist = artist)
////    }
////}
////
////class Artist(
////    var image: ImageBitmap,
////    var name: String,
////    var lastSeenOnline:String
////)
////
////
//class profile{
//    @Composable
//    fun ArtistCardArrangement() {
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.End
//        ) {
//            Image(bitmap = , contentDescription = "Artist image")
//            Column { /*...*/ }
//        }
//    }
//}

//class profile{
//    @Composable
//    fun bgchanger(){
//        Row {
//            val isBlack by remember { mutableStateOf(Black) }
////            Button(onClick = ()){
////                Text("Click me")
////            }
//        }
//    }


////    Define Kotlin data Classes
//    data class Person(
//        val name = String,
//        val title = String,
//        val author = String
//    )
//
//@Composable
//fun NewsHeading(){
//
//////    load json file data
//    val jsonFilePath = "data.json"
//    val jsonString = File(jsonFilePath).readText()
//
////    deserialize json data into kotlin objects
//    val gson = Gson()
//    val personList: List<Person> = gson.fromJson(jsonString,Array<Person>::class.java).toList()
//
////    display Data
//    Text("News")
//    val person = null
//    personList.forEach(person ->{
//        Text("News: ${person.name},Title:- ${persona.title}, Authroe:- ${person.author}")
//    })
////    try {
////
////    }catch (err){
////
////    }
//
//}
//}

class profile {
    @Composable
    fun dataprofile() {

            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .fillMaxHeight(0.4f)
                    .padding(10.dp),
                color = backgroundColor,
                shape = RoundedCornerShape(10.dp),
                elevation = 8.dp
            ) {
                // Content inside Surface
                Column(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                ) {
                    Text("Heading of News")

                    Text("Description of text")
                }
            }
    }
}




//class Profile {
//    @Composable
//    fun btn(onColorChange: (Color) -> Unit) {
//        var backgroundColor by remember { mutableStateOf(Color.White) }
//
//        Button(
//            modifier = Modifier
//                .padding(18.dp)
//                .width(120.dp)
//                .fillMaxWidth(0.5f)
//                .height(50.dp),
//            shape = RoundedCornerShape(18.dp),
//            onClick = {
//                backgroundColor = if (backgroundColor != Color.Black) Color.Black else Color.White
//                onColorChange(backgroundColor)
//            }
//        ) {
//            Text("Click me")
//        }
//    }
//}