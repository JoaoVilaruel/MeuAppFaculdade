package com.example.tela2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tela2.ui.theme.Tela2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tela2Theme {
                MainScreen()
            }
        }
    }
}
@Preview
@Composable
fun MainScreen() {
    var texto by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = { BottomBar() },
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Content(texto, onTextoChange = { texto = it })
        }
    }
}
@Composable
fun Content(texto: String, onTextoChange: (String) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            NewHeader()
            Row {
                Column() {
                    Row {
                        bloco(
                            altura = 300,
                            largura = 180,
                            color = Color.LightGray,
                            texto = "Horários de Aulas",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Column {
                            bloco(
                                altura = 150,
                                largura = 180,
                                color = Color.LightGray,
                                texto = "Notas",
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.titleLarge

                            )
                            bloco(
                                altura = 150,
                                largura = 180,
                                color = Color.LightGray,
                                texto = "N \n Faltas",
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                    }
                    bloco(
                        altura = 120,
                        largura = 360,
                        color = Color.LightGray,
                        texto = "100%",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge

                    )
                    bloco(
                        altura = 60,
                        largura = 360,
                        color = Color.White,
                        texto = "Temas transversais",
                        textAlign = TextAlign.Left,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text("Meu Curso", style = MaterialTheme.typography.titleLarge)
            CategoryRows()
        }
    }
}
@Composable
fun BottomBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        color = Color(0xFFE0E0E0),
        shadowElevation = 6.dp,
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { /* TODO: Home */ }) {
                Icon(Icons.Default.Home, contentDescription = "Home")
            }
            IconButton(onClick = { /* TODO: Criar */ }) {
                Icon(Icons.Default.Create, contentDescription = "Criar")
            }
            IconButton(onClick = { /* TODO: Carrinho */ }) {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Carrinho")
            }
            IconButton(onClick = { /* TODO: Perfil */ }) {
                Icon(Icons.Default.Person, contentDescription = "Perfil")
            }
        }
    }
}
@Composable
fun NewHeader(){
    Spacer(modifier = Modifier.height(10.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Surface(
            modifier = Modifier.size(45.dp),
            color = Color.LightGray,
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Ícone de estrela",
                modifier = Modifier.size(10.dp)
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Column {
            Text("Analise e desenvovimento de sistemas", style = MaterialTheme.typography.titleMedium)
            Text("RGM: 123456789")
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}
@Composable
fun bloco(
    texto: String,
    color: Color,
    altura: Int,
    largura: Int,
    textAlign: TextAlign,
    style: TextStyle,
    imageVector: ImageVector? = null
){
    Surface(
        modifier = Modifier.width(largura.dp).height(altura.dp).padding(5.dp),
        color = color,
        shadowElevation = 6.dp,
        tonalElevation = 6.dp,
        border = BorderStroke(2.dp, Color.DarkGray),
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (imageVector != null) {
                Icon(
                    imageVector = imageVector,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp).padding(end = 8.dp)
                )
            }
            Text(
                text = texto,
                style = style,
                color = Color.Black,
                textAlign = textAlign,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
@Composable
fun CategoryRows() {
    val items = listOf(
        Pair("Histoico Escolar", Icons.Default.Warning),
        Pair("Emissão de Documentos", Icons.Default.Email),
        Pair("Meus documentos", Icons.Default.MailOutline),
    )

    for (i in items.chunked(2)) {
        Row {
            i.forEach { (title, icon) ->
                bloco(
                    texto = title,
                    color = Color.LightGray,
                    altura = 70,
                    largura = 175,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    imageVector = icon
                )
                Spacer(modifier = Modifier.width(5.dp))
            }
        }
    }
}