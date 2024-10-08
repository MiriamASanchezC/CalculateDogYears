package com.example.dogyears

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dogyears.ui.theme.DogYearsTheme

val LightPink = Color(0xFFFFC0CB)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DogYearsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color= colorScheme.background
                )
                {
                    AñosPerrunos()
                }
            }
        }
    }
}

@Composable
fun AñosPerrunos(){
    PosicionPantalla(
        titulo="Mis Años Perrunos",
        imagen= painterResource(id=R.drawable.perrito)

    )
}

@Composable
private fun PosicionPantalla(titulo:String, imagen: Painter, modifier:Modifier=Modifier) {
    Column(
        modifier=modifier.padding(16.dp),

        ){
        var edad by remember {mutableStateOf("")}
        var resultado by remember {mutableStateOf("")
        }
        Image(
            painter=imagen,
            contentDescription =null,
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.Center
        )
        Text(
            text=titulo,
            modifier=Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Mi edad humana")}

        )


        ElevatedButton(
            onClick = {
                var res=0
                res=edad.toInt() * 7
                resultado=res.toString()
            },
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = LightPink,
                contentColor = Color.Black

            ))
        {
            Text("Calcular")
        }

        OutlinedTextField(
            value = resultado,
            readOnly = true,
            onValueChange = { resultado = it },
            label = { Text("Edad Perruna") }
        )
        ElevatedButton(onClick = {
            resultado = ""
            edad = ""
        },
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = LightPink,
                contentColor = Color.Black

            )
        )
        {
            Text(text = "Borrar")
        }
    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DogYearsTheme {
        AñosPerrunos() //Funcion de Años perrunos.
    }
}